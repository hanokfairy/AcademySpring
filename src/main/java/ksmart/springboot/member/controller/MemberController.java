package ksmart.springboot.member.controller;

import ksmart.springboot.exam.dto.Member;
import ksmart.springboot.exam.service.ExamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @RestController = @Controller + @ResponseBody
 */
@RestController
public class MemberController {

    private final ExamService examService;

    public MemberController(ExamService examService) {
        this.examService = examService;
    }

    /**
     * @RequestBody 요청한 json 객체를 서버에서 바인딩 받을 때 사용하는 어노테이션
     * json 전달되는 데이터 타입에 맞게 자바타입을 선언해야 한다.
     * DTO로 선언하고 데이터바인딩 받는게 유지보수 시 유리하다.
     * @param paramMap
     * @return
     */
    @PostMapping("/member/searchId")
    public Member getMemberInfo(@RequestBody Map<String, String> paramMap) {
        String memberId = paramMap.get("memberId");
        System.out.println("memberId: " + memberId);
        return examService.getMemberInfoById(memberId);
    }

    @GetMapping("/member/list")
    public List<Member> getMemberList() {
        return examService.getMemberList();
    }

    /**
     * @PathVariable : 주소 맵핑 시 {바인딩 받을 키}
     * 핸들러 메소드 매개변수의 @PathVariable(name="바인딩 받을 키") 데어터타입 변수명
     * @param memberId
     * @return
     */
    @GetMapping("/member/{memberId}")
    public Member getMemberInfoById(@PathVariable(name="memberId") String memberId) {

        return examService.getMemberInfoById(memberId);
    }
}