package demo.swaggertest.v2.controller;

import demo.swaggertest.v2.dto.ListWrapper;
import demo.swaggertest.v2.dto.MemberCreateRequest;
import demo.swaggertest.v2.dto.MemberCreateResponse;
import demo.swaggertest.v2.dto.TestResponse;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2")
public class TestV2Controller implements TestControllerV2Docs{

    @PostMapping("/members")
    public MemberCreateResponse createMember(@RequestBody MemberCreateRequest memberCreateRequest) {
        return new MemberCreateResponse("1", memberCreateRequest.name(), memberCreateRequest.age());
    }

    @GetMapping("/members")
    public ListWrapper<MemberCreateResponse> findAllMembers() {
        MemberCreateResponse memberCreateResponse = new MemberCreateResponse("1", "홍길동", 20);
        MemberCreateResponse memberCreateResponse2 = new MemberCreateResponse("2", "김철수", 30);
        return new ListWrapper<>(List.of(memberCreateResponse, memberCreateResponse2));
    }

    @GetMapping("/members/{id}")
    public MemberCreateResponse findMemberById(@PathVariable Long id) {
        return new MemberCreateResponse("1", "홍길동", 20);
    }

    @GetMapping("/tests")
    public ListWrapper<TestResponse> findAllTests() {
        TestResponse testResponse = new TestResponse(10, "테스트1");
        TestResponse testResponse2 = new TestResponse(20, "테스트2");
        return new ListWrapper<>(List.of(testResponse, testResponse2));
    }
}
