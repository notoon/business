/**
 * Copyright (c) 2013-2015 by The SeedStack authors. All rights reserved.
 *
 * This file is part of SeedStack, An enterprise-oriented full development stack.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.business.sample.interfaces.multi;

import org.seedstack.business.api.interfaces.assembler.MatchingEntityId;


public class MultiRepresentation {
	
	private String id;

	/**
	 * Getter id
	 * 
	 * @return the id
	 */
	@MatchingEntityId
	public String getId() {
		return id;
	}

	/**
	 * Setter id
	 * 
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	public MultiRepresentation(String id) {
		super();
		this.id = id;
	}

	public MultiRepresentation() {
		super();
	}
	
	
	
	
	

}
