//GET API 만들기 : 웹 애플리케이션 서버에서 값을 가져올 때 사용하는 API
//URL의 경로나 파라미터에 변수를 넣어 요청 보냄
package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
//requestMapping설정시 내부에 선언한 메서드의 URL리소스 앞에 requestMapping의 값이 공통 값으로 추가
@RequestMapping("/api/v1/get-api")
public class GetController {

    //1. RequestMapping으로 구현
    //http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    //요청 형식을 get으로만 설정
    public String getHello(){
        return "Hello World";
    }

    //2. 매개변수가 없는 GET 메서드 구현
    //http://localhost:8080/api/v1/get-api/name
    @GetMapping(value = "/name")
    public String getName(){
        return "Flature";
    }

    //3. PathVariable활용하여 GET메서드 구현
    //GetMapping으로 URL 입력시 중괄호를 사용해 어느 위치에서 값을 받을지 지정
    //메서드의 매개변수와 그 값을 연결하기 위해 PathVariable 명시
    //GetMapping 어노테이션과 PathVariable에 지정된 변수 이름을 동일하게 맞춤
    //http://localhost:8080/api/v1/get-api/variable1/{String값}
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        return  variable;
    }

    //GetMapping에서 지정한 변수이름과 메서드 매개변수이름을 동일하게 맞추기 어려울때
    //http://localhost:8080/api/v1/get-api/variable2/{String값}
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var){
        return  var;
    }

    //4. RequestParam 활용
    //쿼리 형식으로 값 전달 -> {key}={value}
    //http://localhost:8080/api/v1/get-api/request1?name=value1&email=value2&organization=value3
    @GetMapping(value = "/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization){
        return name+" "+email+" "+organization;
    }

    //쿼리스트링에 어떤 값이 들어올지 모를 때
    //http://localhost:8080/api/v1/get-api/request2?key1=value1&key2=value2
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param){
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map->{
            sb.append(map.getKey()+":"+map.getValue()+"\n");
        });
        return sb.toString();
    }

    //5. DTO객체 활용
    //DTO(Data Transfer Object) : 다른 레이어 간의 데이터 교환에 활용
    //http://localhost:8080/api/v1/get-api/request3?name=value1&email=value2&organization=value3
    @GetMapping(value="/request3")
    public String getRequestParam3(MemberDto memberDto){
        return memberDto.toString();
    }
}
