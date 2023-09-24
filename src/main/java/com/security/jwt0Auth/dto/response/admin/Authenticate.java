package com.security.jwt0Auth.dto.response.admin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-24 2:55 PM
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Authenticate {
    private String token;
}
