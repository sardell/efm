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
package com.cloudera.cem.efm.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

@ApiModel
public class DeviceInfo {

    @NotBlank
    private String identifier;
    private SystemInfo systemInfo;
    private NetworkInfo networkInfo;

    @ApiModelProperty(
            value = "A unique, long-lived identifier for the MiNiFi-enabled device",
            required = true)
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @ApiModelProperty("Metadata for the device hardware and operating system")
    public SystemInfo getSystemInfo() {
        return systemInfo;
    }

    public void setSystemInfo(SystemInfo systemInfo) {
        this.systemInfo = systemInfo;
    }

    @ApiModelProperty("Metadata for the network interface of this device")
    public NetworkInfo getNetworkInfo() {
        return networkInfo;
    }

    public void setNetworkInfo(NetworkInfo networkInfo) {
        this.networkInfo = networkInfo;
    }

    @Override
    public String toString() {
        return "DeviceInfo{" +
                "identifier='" + identifier + '\'' +
                ", systemInfo=" + systemInfo +
                ", networkInfo=" + networkInfo +
                '}';
    }
}
