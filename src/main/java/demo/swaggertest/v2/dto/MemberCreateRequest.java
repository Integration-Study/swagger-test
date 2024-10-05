package demo.swaggertest.v2.dto;

import jakarta.validation.constraints.NotNull;

public record MemberCreateRequest(
        @NotNull
        String name,
        Integer age
){
}
