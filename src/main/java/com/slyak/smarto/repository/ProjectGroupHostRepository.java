package com.slyak.smarto.repository;

import com.slyak.smarto.domain.ProjectGroupHost;
import com.slyak.smarto.domain.ProjectGroupHostKey;
import com.slyak.spring.jpa.GenericJpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

/**
 * .
 *
 * @author stormning 2018/5/28
 * @since 1.3.0
 */
public interface ProjectGroupHostRepository extends GenericJpaRepository<ProjectGroupHost, ProjectGroupHostKey> {
    List<ProjectGroupHost> findByIdProjectGroupId(Long id);

    @Modifying
    void deleteByIdProjectGroupId(Long id);
}