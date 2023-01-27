package com.ct.tribe.domain.request;

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
public class CreateTribeRequest {
    private String tribeName;
    private String avatar;
}
