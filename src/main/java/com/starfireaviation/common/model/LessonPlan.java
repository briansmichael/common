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

import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * LessonPlan.
 */
@Data
public class LessonPlan extends Base implements Serializable {

    /**
     * Default SerialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Created At.
     */
    private Date createdAt = new Date();

    /**
     * Updated At.
     */
    private Date updatedAt = new Date();

    /**
     * Title.
     */
    private String title;

    /**
     * Summary.
     */
    private String summary;

    /**
     * Objective.
     */
    private String objective;

    /**
     * Content.
     */
    private String content;

    /**
     * Schedule.
     */
    private String schedule;

    /**
     * Equipment.
     */
    private String equipment;

    /**
     * Instructor's Actions.
     */
    private String instructorActions;

    /**
     * Student's Actions.
     */
    private String studentActions;

    /**
     * Completion Standards.
     */
    private String completionStandards;

    /**
     * Activities.
     */
    private List<Long> activityIds;

    /**
     * Lessons.
     */
    private List<Long> lessonIds;

    /**
     * Presentable flag.
     */
    private boolean presentable;
}
