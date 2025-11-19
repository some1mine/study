package site.thedeny1106.study.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import site.thedeny1106.study.member.Member;

import java.util.UUID;

@Tag(name = "Test", description = "Test API")
@RestController
public class TestController {
    @Operation(summary = "Test", description = "Hello 반환")
    @GetMapping("/")
    public String test() {
        return "Hello";
    }


}
