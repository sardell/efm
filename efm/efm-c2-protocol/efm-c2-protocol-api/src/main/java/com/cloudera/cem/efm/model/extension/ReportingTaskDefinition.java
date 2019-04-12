/*
 * Apache NiFi - MiNiFi
 * Copyright 2014-2018 The Apache Software Foundation
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cloudera.cem.efm.model.extension;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@ApiModel
public class ReportingTaskDefinition extends ExtensionComponent implements ConfigurableComponentDefinition {

    private Map<String, PropertyDescriptor> propertyDescriptors;
    private List<String> supportedSchedulingStrategies;
    private String defaultSchedulingStrategy;
    private Map<String, Map<String, String>> defaultValuesBySchedulingStrategy;
    private boolean supportsDynamicProperties;

    @Override
    @ApiModelProperty("Descriptions of configuration properties applicable to this reporting task")
    public Map<String, PropertyDescriptor> getPropertyDescriptors() {
        return (propertyDescriptors != null ? Collections.unmodifiableMap(propertyDescriptors) : null);
    }

    @Override
    public void setPropertyDescriptors(LinkedHashMap<String, PropertyDescriptor> propertyDescriptors) {
        this.propertyDescriptors = propertyDescriptors;
    }

    @Override
    @ApiModelProperty("Whether or not this reporting task makes use of dynamic (user-set) properties")
    public boolean getSupportsDynamicProperties() {
        return supportsDynamicProperties;
    }

    @Override
    public void setSupportsDynamicProperties(boolean supportsDynamicProperties) {
        this.supportsDynamicProperties = supportsDynamicProperties;
    }

    @ApiModelProperty
    public List<String> getSupportedSchedulingStrategies() {
        return (supportedSchedulingStrategies != null ? Collections.unmodifiableList(supportedSchedulingStrategies) : null);
    }

    public void setSupportedSchedulingStrategies(List<String> supportedSchedulingStrategies) {
        this.supportedSchedulingStrategies = supportedSchedulingStrategies;
    }

    @ApiModelProperty
    public String getDefaultSchedulingStrategy() {
        return defaultSchedulingStrategy;
    }

    public void setDefaultSchedulingStrategy(String defaultSchedulingStrategy) {
        this.defaultSchedulingStrategy = defaultSchedulingStrategy;
    }

    @ApiModelProperty
    public Map<String, Map<String, String>> getDefaultValuesBySchedulingStrategy() {
        return (defaultValuesBySchedulingStrategy != null ? Collections.unmodifiableMap(defaultValuesBySchedulingStrategy) : null);
    }

    public void setDefaultValuesBySchedulingStrategy(Map<String, Map<String, String>> defaultValuesBySchedulingStrategy) {
        this.defaultValuesBySchedulingStrategy = defaultValuesBySchedulingStrategy;
    }
}
