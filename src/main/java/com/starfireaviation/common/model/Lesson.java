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

/**
 * Lesson.
 */
@Data
public class Lesson implements Serializable {

    /**
     * Default SerialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * ID.
     */
    private Long id;

    /**
     * Created At.
     */
    private Date createdAt = new Date();

    /**
     * Updated At.
     */
    private Date updatedAt = new Date();

    /**
     * Group.
     */
    private String group;

    /**
     * Chapter.
     */
    private Long chapter;

    /**
     * Text.
     */
    private String text;

    /**
     * Required for course.
     */
    private boolean required;

}
