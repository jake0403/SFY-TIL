package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    // 다음과 같이 MemeberService 객체를 새로 생성해 쓸 수 있지만
    // Spring Container에서 관리할 수 있고 다른 Controller들도 MemberService를 사용할 수 있기 떄문에
    // 의존성 관리를 위해 Container에 등록을 해준다.
    //private final MemberService memberService = new MemberService();
    private final MemberService memberService;

    // Autowired 어노테이션은 Spring Container에 등록된 Bean 객체를 자동으로 연결해줌
    // 이것을 Dependency Injection (DI), 의존성 주입이라고 한다.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }




}
