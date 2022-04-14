package ua.com.yummzy.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.com.yummzy.dto.DishDto;
import ua.com.yummzy.service.DishService;
import ua.com.yummzy.utils.Endpoints;

import java.util.List;

@RestController
@RequestMapping(Endpoints.DISH)
@RequiredArgsConstructor
@SecurityRequirement(name = "bearer")
public class DishController {
    private final DishService dishService;

    @GetMapping("/random")
    public List<DishDto> getRandom(@RequestParam(defaultValue = "20") int size) {
        return dishService.getAllRandom(size);
    }

    @GetMapping("/{id}")
    public DishDto getById(@PathVariable String id) {
        return dishService.getById(id);
    }
}
