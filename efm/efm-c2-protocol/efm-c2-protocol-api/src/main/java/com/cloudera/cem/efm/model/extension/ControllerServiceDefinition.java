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
import java.util.Map;

@ApiModel
public class ControllerServiceDefinition extends ExtensionComponent implements ConfigurableComponentDefinition {

    private Map<String, PropertyDescriptor> propertyDescriptors;
    private boolean supportsDynamicProperties;

    @Override
    @ApiModelProperty("Descriptions of configuration properties applicable to this controller service")
    public Map<String, PropertyDescriptor> getPropertyDescriptors() {
        return (propertyDescriptors != null ? Collections.unmodifiableMap(propertyDescriptors) : null);
    }

    @Override
    public void setPropertyDescriptors(LinkedHashMap<String, PropertyDescriptor> propertyDescriptors) {
        this.propertyDescriptors = propertyDescriptors;
    }

    @Override
    @ApiModelProperty("Whether or not this processor makes use of dynamic (user-set) properties")
    public boolean getSupportsDynamicProperties() {
        return supportsDynamicProperties;
    }

    @Override
    public void setSupportsDynamicProperties(boolean supportsDynamicProperties) {
        this.supportsDynamicProperties = supportsDynamicProperties;
    }

}
