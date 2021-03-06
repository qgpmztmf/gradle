/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gradle.api.plugins.jvm;

import org.gradle.api.Incubating;
import org.gradle.api.Task;
import org.gradle.api.file.DirectoryProperty;
import org.gradle.api.tasks.TaskProvider;

import java.util.function.Function;

/**
 * A source directory set builder which assumes that the sources are generated
 * by a task.
 *
 * @since 6.8
 */
@Incubating
public interface JvmLanguageGeneratedSourceDirectoryBuilder extends JvmLanguageSourceDirectoryBuilder {
    /**
     * Registers a source generation task
     * @param taskProvider the task which generates sources
     * @param mapping a function which returns the sources output directory generated by this task
     * @param <T> the type of the source generation task
     */
    <T extends Task> JvmLanguageGeneratedSourceDirectoryBuilder forSourceGeneratingTask(TaskProvider<T> taskProvider, Function<T, DirectoryProperty> mapping);
}
