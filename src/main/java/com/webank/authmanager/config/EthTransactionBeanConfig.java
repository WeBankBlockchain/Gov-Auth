/**
 * Copyright 2014-2019 the original author or authors.
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
package com.webank.authmanager.config;

import java.math.BigInteger;

import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.tx.ExtendedRawTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import lombok.extern.slf4j.Slf4j;

/**
 * EthTransactionBeanConfig
 *
 * @Description: EthTransactionBeanConfig
 * @author maojiayu
 * @data Oct 30, 2019 5:39:32 PM
 *
 */
@Slf4j
@Configuration
@Order(100)
public class EthTransactionBeanConfig {
    @Autowired
    private Web3j web3j;
    @Autowired
    private Credentials credentials;
    @Autowired
    private SystemEnvironmentConfig systemEnvironmentConfig;

    @Bean
    public ExtendedRawTransactionManager get() {
        ExtendedRawTransactionManager manager = new ExtendedRawTransactionManager(web3j, credentials,
                BigInteger.valueOf(systemEnvironmentConfig.getGroupId()), BigInteger.ONE);
        return manager;
    }

}
