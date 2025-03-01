/*
 * Copyright 2017-2019 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.grpc.channels;

import io.micronaut.context.annotation.EachProperty;
import io.micronaut.context.annotation.Parameter;
import io.micronaut.context.env.Environment;
import io.micronaut.scheduling.TaskExecutors;

import jakarta.inject.Named;
import java.util.concurrent.ExecutorService;

/**
 * Constructs a named channel configuration for each property specified in {@link GrpcManagedChannelConfiguration#PREFIX}.
 *
 * @author graemerocher
 * @since 1.0.0
 */
@EachProperty(GrpcManagedChannelConfiguration.PREFIX)
public class GrpcNamedManagedChannelConfiguration extends GrpcManagedChannelConfiguration {

    /**
     * Default constructor.
     * @param name The name
     * @param env The environment
     * @param executorService The executor service
     */
    public GrpcNamedManagedChannelConfiguration(
            @Parameter String name,
            Environment env,
            @Named(TaskExecutors.IO) ExecutorService executorService) {
        super(name, env, executorService);
    }
}
