package ksmart.springboot.exam.controller;

import jakarta.annotation.PostConstruct;
import ksmart.springboot.exam.dto.Member;
import ksmart.springboot.exam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Controller : 주소의 요청과 응답을 담당하는 클래스 (HTTP 통신)
 *      VIEW의 경로가 정해져 있다. (String : 뷰의 논리적인 경로)
 *
 * 클래스 위에 @Component 작성하게 되면 spring framework가 관리하는 객체로 생성 (spring bean)
 * @Component 계열 : @Controller, @Service, @Repository(DAO), @Mapper(DAO), @Configuration(스프링 설정),
 *                : 일반적인 클래스를 spring bean 등록하고자 하면 클래스 위에 @Component
 */

@Controller
public class ExamController {

    // DI(Dependency Injection : 의존성 주입)
    // 의존성주입 : 클래스 간의 관계를 형성, 스프링이 관리하는 객체를
    // 하나의 객체가 다른 객체의 의존성을 제공하는 테크닉
    // "의존성"은 예를 들어 서비스로 사용할 수 있는 객체

    // 1. 필드 주입 방식
    //@Autowired
    //private ExamService examService;

    // 2. 수정자 메소드 주입방식
    //private ExamService examService;

    //@Autowired
    //public void setExamService(ExamService examService) {
    //    this.examService = examService;
    //}

    // 3. 생성자 메서드 주입방식
    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    // @PostConstruct spring 객체를 생성한 후에 이벤트를 실행하는 어노테이션
    @PostConstruct
    public void initExamController() {
        System.out.println("ExamController 객체생성");
    }

    @RequestMapping(value = "/exam/exam2", method = RequestMethod.GET)
    public ModelAndView exam2() {
        // ExamService examService = new ExamService();
        List<Member> memberList = examService.getMemberList();
        System.out.println(memberList);

        ModelAndView mav = new ModelAndView();
        mav.addObject("title", "예제2"); // 화면에 전달할 data를 셋팅하는 방법
        mav.setViewName("exam/exam2");
        return mav;
    }

    /**
     * @GetMapping : GET 방식의 HTTP 주소요청시 특정핸들러 메소드와 맵핑시켜주는 어노테이션
     * @return => VIEW 경로와 연관되어있다.
     */
    @GetMapping("/exam/exam1")
    public String exam1(Model model) {
        Member memberInfo = new Member("id001", "pw001", "홍01", "관리자", "010-1111-1111");
        // Model : 화면에 전달될 데이터를 가지고 있는 객체
        model.addAttribute("title", "예제1");
        model.addAttribute("memberInfo", memberInfo);
        return "exam/exam1";
    }
}
