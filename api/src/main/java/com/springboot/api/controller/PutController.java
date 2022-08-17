//PUT API : 웹 애플리케이션 서버를 통해 데이터베이스 같은 저장소에 존재하는 리소스 값을 업데이트하는데 사용
package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

    //1. RequestBody 활용
    //http://localhost:8080/api/v1/put-api/member
    @PutMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> putData){
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map ->{
            sb.append(map.getKey()+":"+map.getValue()+"\n");
        });
        return sb.toString();
    }

    //2. DTO객체 활용
    //http://localhost:8080/api/v1/put-api/member1
    @PutMapping(value = "/member1")
    public String postMemberDto1(@RequestBody MemberDto memberDto){
        return memberDto.toString();        //return값이 String
    }

    //http://localhost:8080/api/v1/put-api/member2
    @PutMapping(value = "/member2")
    public MemberDto postMemberDto2(@RequestBody MemberDto memberDto){
        return memberDto;        //return값이 DTO객체
    }

    //3. ResponseEntity 활용
    //HttpEntity 상속 받음
    //ResponseEntity는 서버에 들어온 요청에 대해 응답 데이터를 구성해ㅔ서 전달할 수 있게 함
    //http://localhost:8080/api/v1/put-api/member3
    @PutMapping(value = "/member3")
    public ResponseEntity<MemberDto> postMemberDto3(@RequestBody MemberDto memberDto){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDto);
    }
}
