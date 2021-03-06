package com.slyak.smarto.repository;

import com.slyak.smarto.domain.OS;
import com.slyak.spring.jpa.GenericJpaRepository;

/**
 * .
 *
 * @author stormning 2018/5/11
 * @since 1.3.0
 */
public interface OSRepository extends GenericJpaRepository<OS, Long> {

    OS findByOs(String os);
}
