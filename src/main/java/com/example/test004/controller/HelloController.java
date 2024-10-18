package com.example.test004.controller;

import com.example.test004.config.DatabaseContextHolder;
import com.example.test004.dto.HelloResponseDto;

import com.example.test004.entity.Role;
import com.example.test004.model.TestOrder;
import com.example.test004.model.TestApiResponse;
import com.example.test004.model.enums.ApiResult;
import com.example.test004.repository.RoleRepository;
import com.example.test004.service.HelloService;
import java.io.File;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tika.Tika;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
public class HelloController {
    private final RoleRepository roleRepository;
    private final HelloService helloService;
    private final Tika tika = new Tika();

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount) {
        return HelloResponseDto.builder()
                .name(name)
                .amount(amount)
                .build();
    }

    @GetMapping("/test0")
    public void getRoles0() {
        List<Role> all = roleRepository.findAll();
        System.out.println(all.toString());
        System.out.println(DatabaseContextHolder.getDbType());
    }

    @GetMapping("/test1")
    @Transactional
    public void getRoles1() {
        List<Role> all = roleRepository.findAll();
        System.out.println(all.toString());
        System.out.println(DatabaseContextHolder.getDbType());
    }

    @GetMapping("/test2")
    @Transactional(readOnly = true)
    public void getRoles2() {
        List<Role> all = roleRepository.findAll();
        System.out.println(all.toString());
        System.out.println(DatabaseContextHolder.getDbType());
    }

    @GetMapping("/test3")
    public void getRoles3() {
        helloService.test0();
    }

    @GetMapping("/test4")
    public ResponseEntity<TestApiResponse> test4() {
        TestApiResponse response = new TestApiResponse(ApiResult.SUCCESS);
        return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @GetMapping("/test5")
    public ResponseEntity<TestApiResponse> test5() throws IOException {
        File aFile = new File("C:\\Users\\guhada\\Pictures\\medium-sized-image-2.2mb.jpg");
        String detect = tika.detect(aFile);
        log.info(detect);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/test6")
    public ResponseEntity<TestApiResponse> test6() {
        TestOrder bo = TestOrder.builder()
                .noteSample("efefef")
                .orderSample("ababab")
                .build();

        return ResponseEntity.ok(new TestApiResponse(ApiResult.SUCCESS, bo));
    }
}
