package http.httptest.repository;

import http.httptest.dto.UserDto;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class TestRepository {
    private final HashMap<String, UserDto> userDtoList = new HashMap<>();

    // @PostConstruct 통해서 IoC컨데이터에서 TestRepository 빈의 의존관계 설정 후 초기화함
    @PostConstruct
    public void init(){
        for(int i = 0; i < 10; i++){
            UserDto userDto = new UserDto();
            userDto.setName("name" + i);
            userDtoList.put("name"+i,userDto);
        }
    }

    public String findAll(){
        return "정적 데이터 조회 " + userDtoList;
    }

    public String findByName(String name) {
        UserDto userDto = userDtoList.get(name);
        if(userDto == null){
            return name + " 는 등록되어 있지 않음";
        }
        return userDto.getName() + " 는 등록되어 있음 : " + userDto;
    }

    public void put(UserDto userDto) {
        userDtoList.put(userDto.getName(),userDto);
    }
}