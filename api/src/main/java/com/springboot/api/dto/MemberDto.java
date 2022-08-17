package com.springboot.api.dto;

//쿼리스트링의 키가 정해져있지만 받아야할 파라미터가 많을 경우 DTO객체 활용
public class MemberDto {
    private String name;
    private String email;
    private String organization;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Override
    public String toString(){
        return "MemberDto{"+
                "name="+name+'\''+
                ", email='"+email+'\''+
                ", organization='"+organization+'\''+
                '}';
    }
}
