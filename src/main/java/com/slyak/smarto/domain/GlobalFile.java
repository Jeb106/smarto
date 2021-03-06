package com.slyak.smarto.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;

/**
 * .
 *
 * @author stormning 2018/4/27
 * @since 1.3.0
 */
@Entity
@Table(name = "t_mfile",uniqueConstraints = @UniqueConstraint(columnNames = "md5"))
@Data
public class GlobalFile implements Serializable {
    @Id
    private String id;
    private String name;
    private long size;
    private String md5;
}
