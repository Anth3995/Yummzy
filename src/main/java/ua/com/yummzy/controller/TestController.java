package ua.com.yummzy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.yummzy.utils.Endpoints;

@RestController
@RequestMapping(Endpoints.API_PREFIX)
@RequiredArgsConstructor
public class TestController {

    @GetMapping("/test-security")
    public ResponseEntity<String> testSecurity() {
        return ResponseEntity.ok("test security endpoint");
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("test public endpoint");
    }
}
