package demo.swaggertest.v2.controller;

import demo.swaggertest.v2.dto.ApiResponseDto;
import demo.swaggertest.v2.dto.ListWrapper;
import demo.swaggertest.v2.dto.MemberCreateRequest;
import demo.swaggertest.v2.dto.MemberCreateResponse;
import demo.swaggertest.v2.dto.TestResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "TestController V2", description = "테스트 컨트롤러 버전2 설명입니다.")
interface TestControllerV2Docs {

    @Operation(summary = "새 멤버 등록", description = "멤버 정보를 입력받아 새로운 멤버를 등록합니다.")
    @ApiResponse(responseCode = "200", description = "성공", useReturnTypeSchema = true)
    @ApiResponse(responseCode = "400", description = "잘못된 요청", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponseDto.class)))
    MemberCreateResponse createMember(MemberCreateRequest memberCreateRequest);

    @Operation(summary = "모든 멤버 조회", description = "모든 멤버를 조회합니다.")
    @ApiResponse(responseCode = "200", description = "성공", useReturnTypeSchema = true)
    ListWrapper<MemberCreateResponse> findAllMembers();

    @Operation(summary = "멤버 단건 조회", description = "멤버 아이디로 멤버를 조회합니다.")
    @ApiResponse(responseCode = "200", description = "성공", useReturnTypeSchema = true)
    @ApiResponse(responseCode = "404", description = "멤버 없음", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponseDto.class)))
    MemberCreateResponse findMemberById(Long id);

    @Operation(summary = "테스트 조회", description = "generic 자동 변환 테스트입니다.")
    @ApiResponse(responseCode = "200", description = "성공", useReturnTypeSchema = true)
    ListWrapper<TestResponse> findAllTests();
}

