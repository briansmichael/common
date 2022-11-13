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

package com.starfireaviation.common.model;

import java.io.Serializable;
import java.time.Instant;
import lombok.Data;


@Data
public class Message extends Base implements Comparable<Message>, Serializable {

    /**
     * Priority.
     */
    private Priority priority;

    /**
     * Payload.
     */
    private String payload;

    /**
     * NotificationType.
     */
    private NotificationType notificationType;

    /**
     * NotificationEventType.
     */
    private NotificationEventType notificationEventType;

    /**
     * User ID.
     */
    private Long userId;

    /**
     * Quiz ID.
     */
    private Long quizId;

    /**
     * Event ID.
     */
    private Long eventId;

    /**
     * Question ID.
     */
    private Long questionId;

    /**
     * Lesson ID.
     */
    private Long lessonId;

    /**
     * Reference Material ID.
     */
    private Long referenceMaterialId;

    /**
     * Expiration time.
     */
    private Instant expirationTime;

    /**
     * Compares this message's priority to another message's priority.
     *
     * @param other the object to be compared.
     * @return priority order
     */
    @Override
    public int compareTo(final Message other) {
        if (getPriority() != other.getPriority()) {
            if (other.getPriority() == Priority.HIGH) {
                return -1;
            }
            if (other.getPriority() == Priority.LOW) {
                return 1;
            }
        }
        return 0;
    }
}
