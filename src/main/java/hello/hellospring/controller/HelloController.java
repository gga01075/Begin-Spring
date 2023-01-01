package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "스프링부트 공부중입니다.");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }


    @GetMapping("hello-api")
    /*
    서버에서 클라이언트로 응답 데이터를 전송하기 위해 @ResponseBody 어노테이션을 사용하여
    자바 객체를 HTTP 응답 본문의 객체로 변환하여 클라이언트로 전송한다.
    */
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {

        // Hello클래스로 만든 hello 인스턴스 생성
        Hello hello = new Hello();

        // 파라미터로 받은 name을 객체에 setting시켜준다.
        hello.setName(name);

        // hello 인스턴스 반환
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }




}