package demo.swaggertest.v1.dto;

import jakarta.validation.constraints.NotNull;

public record MemberCreateRequest(
        @NotNull
        String name,
        Integer age
){
}
