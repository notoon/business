/**
 * Copyright (c) 2013-2015 by The SeedStack authors. All rights reserved.
 *
 * This file is part of SeedStack, An enterprise-oriented full development stack.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.business.api.domain.events.fixtures;

import org.seedstack.business.api.EventHandler;

/**
 * @author pierre.thirouin@ext.mpsa.com
 *         Date: 04/06/2014
 */
public class MyEventHandlerFailed implements EventHandler<MyEvent2> {

    @Override
    public void handle(MyEvent2 event) {
        throw new RuntimeException();
    }
}
