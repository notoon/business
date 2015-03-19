/**
 * Copyright (c) 2013-2015 by The SeedStack authors. All rights reserved.
 *
 * This file is part of SeedStack, An enterprise-oriented full development stack.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.business.api.interfaces.assembler;

import org.seedstack.business.sample.domain.customer.Customer;

public class VipAssembler extends BaseAssembler<Customer, VipRepresentation> {

    @Override
    protected void doAssembleDtoFromAggregate(VipRepresentation targetDto, Customer sourceEntity) {
        targetDto.setName(sourceEntity.getFullName());
        targetDto.setId(sourceEntity.getEntityId().getCustomerId());
        targetDto.setVipName("vip");
    }

    @Override
    public void doMergeAggregateWithDto(Customer targetEntity, VipRepresentation sourceDto) {
        String[] split = sourceDto.getName().split(" ");
        targetEntity.setFirstName(split[1].trim());
        targetEntity.setLastName(split[0].trim());
    }
}