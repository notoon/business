/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.business.fixtures;

import org.seedstack.business.domain.AggregateRoot;
import org.seedstack.business.domain.BaseRepository;
import org.seedstack.business.domain.RepositoryOptions;
import org.seedstack.business.domain.specification.Specification;
import org.seedstack.seed.persistence.inmemory.InMemory;

import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Repository for in memory persistence.
 * <p>
 * When no specific repository exist for the aggregate, this repository will be injected for
 * {@link org.seedstack.business.domain.Repository} with the qualifier {@literal @}InMemory.
 * </p>
 */
public class InMemoryRepository<Aggregate extends AggregateRoot<Key>, Key> extends BaseRepository<Aggregate, Key> {
    @InMemory
    protected Map<Key, Aggregate> inMemorySortedMap;

    @Override
    public Optional<Aggregate> get(Key id) {
        return Optional.ofNullable(inMemorySortedMap.get(id));
    }

    @Override
    public Stream<Aggregate> get(Specification<Aggregate> specification, RepositoryOptions... options) {
        // TODO: implement options
        return inMemorySortedMap.values().stream().filter(specification.asPredicate());
    }

    @Override
    public boolean contains(Key id) {
        return inMemorySortedMap.containsKey(id);
    }

    @Override
    public long count() {
        return inMemorySortedMap.size();
    }

    @Override
    public void clear() {
        inMemorySortedMap.clear();
    }

    @Override
    public long count(Specification<Aggregate> specification) {
        return get(specification).count();
    }

    @Override
    public void remove(Key id) {
        inMemorySortedMap.remove(id);
    }

    @Override
    public long remove(Specification<Aggregate> specification) {
        Iterator<Map.Entry<Key, Aggregate>> iterator = inMemorySortedMap.entrySet().iterator();
        int count = 0;
        while (iterator.hasNext()) {
            Map.Entry<Key, Aggregate> next = iterator.next();
            if (specification.isSatisfiedBy(next.getValue())) {
                iterator.remove();
                count++;
            }
        }
        return count;
    }

    @Override
    public void remove(Aggregate aggregate) {
        inMemorySortedMap.remove(aggregate.getEntityId());
    }

    @Override
    public void add(Aggregate aggregate) {
        inMemorySortedMap.put(aggregate.getEntityId(), aggregate);
    }

    @Override
    public Aggregate update(Aggregate aggregate) {
        return inMemorySortedMap.put(aggregate.getEntityId(), aggregate);
    }
}
