/*
 * Copyright 2018 the original author or authors.
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

package org.gradle.kotlin.dsl.accessors

import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.reflect.TypeOf.parameterizedTypeOf

import org.gradle.kotlin.dsl.fixtures.AbstractDslTest
import org.gradle.kotlin.dsl.typeOf


abstract class ProjectSchemaBasedTest : AbstractDslTest() {

    protected
    fun namedDomainObjectContainerOf(elementType: SchemaType) =
        SchemaType(parameterizedTypeOf(typeOf<NamedDomainObjectContainer<*>>(), elementType.value))

    protected
    inline fun <reified ReceiverType, reified EntryType> entry(name: String): ProjectSchemaEntry<SchemaType> =
        ProjectSchemaEntry(SchemaType.of<ReceiverType>(), name, SchemaType.of<EntryType>())
}
