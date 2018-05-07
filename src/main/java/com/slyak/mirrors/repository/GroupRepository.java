package com.slyak.mirrors.repository;

import com.slyak.mirrors.domain.HostGroup;
import com.slyak.spring.jpa.GenericJpaRepository;

/**
 * .
 *
 * @author stormning 2018/4/17
 * @since 1.3.0
 */
public interface GroupRepository extends GenericJpaRepository<HostGroup, Long> {
}