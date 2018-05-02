package com.slyak.mirrors.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * .
 *
 * @author stormning 2018/4/27
 * @since 1.3.0
 */
@Data
@AllArgsConstructor
public class GroupHostResponse implements Serializable {
    private Long groupHostId;
    private String response;
}