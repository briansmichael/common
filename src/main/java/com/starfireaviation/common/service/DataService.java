/*
 *  Copyright (C) 2022 Starfire Aviation, LLC
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.starfireaviation.common.service;

import com.starfireaviation.common.model.LessonPlan;
import com.starfireaviation.common.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Slf4j
public class DataService {

    /**
     * Gets a User by username.
     *
     * @param name user name
     * @return User
     */
    public User getUser(final String name) {
        final WebClient client = WebClient.create("https://users.starfireaviation.com");
        try {
            final Mono<List<Long>> response = client
                    .get()
                    .uri("/api/users?username=" + name)
                    .retrieve()
                    .bodyToMono(new ParameterizedTypeReference<>() {
                    });
            final List<Long> userIds = response.block();
            if (userIds != null && userIds.size() == 1) {
                final Long userId = userIds.get(0);
                if (userId != null) {
                    return getUser(userId);
                }
            }
        } catch (WebClientException wce) {
            log.error("getUser(name): {}", wce.getMessage());
        }
        return null;
    }

    /**
     * Gets a User by ID.
     *
     * @param userId user ID
     * @return User
     */
    public User getUser(final Long userId) {
        final WebClient client = WebClient.create("https://users.starfireaviation.com");
        try {
            final Mono<User> response = client
                    .get()
                    .uri("/api/users/" + userId)
                    .retrieve()
                    .bodyToMono(User.class);
            return response.block();
        } catch (WebClientException wce) {
            log.error("getUser(userId): {}", wce.getMessage());
        }
        return null;
    }

    /**
     * Checks if a LessonPlan exists for the provided ID.
     *
     * @param lessonPlanId LessonPlan ID
     * @return if LessonPlan exists
     */
    public boolean existsLessonPlan(final Long lessonPlanId) {
        if (getLessonPlan(lessonPlanId) != null) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * Gets a LessonPlan.
     *
     * @param lessonPlanId LessonPlan ID
     * @return LessonPlan
     */
    public LessonPlan getLessonPlan(final Long lessonPlanId) {
        final WebClient client = WebClient.create("https://lessons.starfireaviation.com");
        try {
            final Mono<LessonPlan> response = client
                    .get()
                    .uri("/api/lessonplans/" + lessonPlanId)
                    .retrieve()
                    .bodyToMono(LessonPlan.class);
            return response.block();
        } catch (WebClientException wce) {
            log.error("getLessonPlan(): {}", wce.getMessage());
        }
        return null;
    }

    /**
     * Gets all presentable LessonPlans.
     *
     * @param group Group or Course
     * @return list of LessonPlan IDs
     */
    public List<Long> getAllPresentableLessonPlans(final String group) {
        final WebClient client = WebClient.create("https://lessons.starfireaviation.com");
        try {
            final Mono<List<Long>> response = client
                    .get()
                    .uri("/api/lessonplans?presentable=true&group=" + group)
                    .retrieve()
                    .bodyToMono(new ParameterizedTypeReference<>() {
                    });
            return response.block();
        } catch (WebClientException wce) {
            log.error("getAllPresentableLessonPlans(group): {}", wce.getMessage());
        }
        return null;
    }
}
