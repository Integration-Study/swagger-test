package demo.swaggertest.v1.controller;

import demo.swaggertest.v1.dto.ApiResponseDto;
import demo.swaggertest.v1.dto.ListWrapper;
import demo.swaggertest.v1.dto.MemberCreateRequest;
import demo.swaggertest.v1.dto.MemberCreateResponse;
import demo.swaggertest.v1.dto.TestResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "TestController V1", description = "테스트 컨트롤러 버전1 설명입니다.")
@RequestMapping("/v1")
public class TestControllerV1 {

    @Operation(summary = "새 멤버 등록", description = "멤버 정보를 입력받아 새로운 멤버를 등록합니다.")
    @ApiResponse(responseCode = "200", description = "성공", useReturnTypeSchema = true)
    @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponseDto.class)))
    @PostMapping("/members")
    public MemberCreateResponse createMember(
            @RequestBody MemberCreateRequest memberCreateRequest) {
        return new MemberCreateResponse("1", "홍길동", 20);
    }


    @Operation(summary = "모든 멤버 조회", description = "모든 멤버를 조회합니다.")
    @ApiResponse(responseCode = "200", description = "성공", useReturnTypeSchema = true)
    @GetMapping("/members")
    public ListWrapper<MemberCreateResponse> findAllMembers() {
        MemberCreateResponse memberCreateResponse = new MemberCreateResponse("1", "홍길동", 20);
        MemberCreateResponse memberCreateResponse2 = new MemberCreateResponse("2", "김철수", 30);
        return new ListWrapper<>(List.of(memberCreateResponse, memberCreateResponse2));
    }

    @Operation(summary = "멤버 단건 조회", description = "멤버 아이디로 멤버를 조회합니다.")
    @ApiResponse(responseCode = "200", description = "성공", useReturnTypeSchema = true)
    @ApiResponse(responseCode = "404", description = "멤버 없음", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponseDto.class)))
    @GetMapping("/members/{id}")
    public MemberCreateResponse findMemberById(@PathVariable Long id) {
        return new MemberCreateResponse("1", "홍길동", 20);
    }


    @Operation(summary = "테스트 조회", description = "generic 자동 변환 테스트입니다.")
    @ApiResponse(responseCode = "200", description = "성공", useReturnTypeSchema = true)
    @ApiResponse(responseCode = "404", description = "테스트 없음", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponseDto.class)))
    @GetMapping("/tests")
    public ListWrapper<TestResponse> findAllTests() {
        TestResponse testResponse = new TestResponse(10, "테스트1");
        TestResponse testResponse2 = new TestResponse(20, "테스트2");
        return new ListWrapper<>(List.of(testResponse, testResponse2));
    }
}

