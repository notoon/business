/**
 * Copyright (c) 2013-2015 by The SeedStack authors. All rights reserved.
 *
 * This file is part of SeedStack, An enterprise-oriented full development stack.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
/**
 * 
 */
package org.seedstack.business.core.domain.identity;

import org.apache.commons.configuration.Configuration;
import org.seedstack.business.api.domain.Entity;
import org.seedstack.business.api.domain.base.BaseEntity;
import org.seedstack.business.api.domain.identity.UUIDHandler;

import javax.inject.Named;
import java.util.UUID;

/**
 * Uuid handler
 * 
 * @author redouane.loulou@ext.mpsa.com
 */
@Named("simple-UUID")
public class SimpleUUIDHandler implements UUIDHandler<BaseEntity<UUID>,UUID>{

	@Override
	public UUID handle(Entity entity, Configuration entityConfiguration) {
		return UUID.randomUUID();		
	}

}
