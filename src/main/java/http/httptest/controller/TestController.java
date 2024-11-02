package http.httptest.controller;

import http.httptest.dto.UserDto;
import http.httptest.repository.TestRepository;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class TestController {
    private final TestRepository testRepository;

    public TestController(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    // 정적 데이터 조회
    @GetMapping("/static-search")
    public String staticSearch(){
        return testRepository.findAll();
    }

    // 동적 데이터 조회
    @GetMapping("/dynamic-search/{name}")
    public String dynamicSearch(@PathVariable("name") String name){
        return testRepository.findByName(name);
    }

    // html form
    @PostMapping("/html-form")
    public String htmlForm(@ModelAttribute UserDto userDto){
        testRepository.put(userDto);
        return userDto.getName() + " 등록 완료";
    }

    // multipart/form-data
    @PostMapping("/multipart-form-data")
    public String multipartForm(@ModelAttribute UserDto userDto) throws IOException {
        testRepository.put(userDto);
        return userDto.getName() + " 등록 완료";
    }


    // HTTP API
    @PostMapping("/http-api")
    public UserDto httpApi(@RequestBody UserDto userDto){
        testRepository.put(userDto);
        return userDto;
    }
}
