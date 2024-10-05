package demo.swaggertest.v2.dto;

public record MemberCreateResponse(
        String memberId,
        String name,
        Integer age) {
}
