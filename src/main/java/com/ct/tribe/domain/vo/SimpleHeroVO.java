package com.ct.tribe.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CT
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleHeroVO {
    private Long id;
    private String heroName;
    private Integer statusId;
    private Integer actionId;
}
