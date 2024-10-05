package demo.swaggertest.v1.dto;

public record MemberCreateResponse(
        String memberId,
        String name,
        Integer age
){
}
