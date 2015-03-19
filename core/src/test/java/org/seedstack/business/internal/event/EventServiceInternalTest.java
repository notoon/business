/**
 * Copyright (c) 2013-2015 by The SeedStack authors. All rights reserved.
 *
 * This file is part of SeedStack, An enterprise-oriented full development stack.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.business.internal.event;

import com.google.common.collect.ArrayListMultimap;
import com.google.inject.Injector;
import org.seedstack.business.api.Event;
import org.seedstack.business.api.EventHandler;
import org.seedstack.business.api.EventService;
import org.seedstack.business.api.domain.events.fixtures.MyEvent;
import org.seedstack.business.api.domain.events.fixtures.MyEventHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Tests the event service.
 *
 * @author pierre.thirouin@ext.mpsa.com
 *         Date: 19/08/2014
 */
@RunWith(MockitoJUnitRunner.class)
public class EventServiceInternalTest {

    private EventService underTest;
    @Mock
    private Injector injector;
    @Mock
    private MyEventHandler myEventHandler;

    @Test
    public void fire_event() {
        ArrayListMultimap<Class<? extends Event>, Class<? extends EventHandler>> multiMap = ArrayListMultimap.create();
        multiMap.put(MyEvent.class, MyEventHandler.class);

        // provide an handler of MyEvent
        Mockito.when(injector.getInstance(MyEventHandler.class)).thenReturn(myEventHandler);

        underTest = new EventServiceInternal(injector, multiMap);
        underTest.fire(new MyEvent());
    }

    @Test
    public void fire_event_not_received() {
        ArrayListMultimap<Class<? extends Event>, Class<? extends EventHandler>> multiMap = ArrayListMultimap.create();
        // no handler provided
        underTest = new EventServiceInternal(injector, multiMap);
        underTest.fire(new MyEvent());
    }
}
