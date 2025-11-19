package site.thedeny1106.projectPay.interfaces.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Test", description = "Test API")
@RestController
public class TestController {
    @Operation(summary = "Test", description = "Hello 반환")
    @GetMapping("/")
    public String test() {
        return "Hello";
    }


}
