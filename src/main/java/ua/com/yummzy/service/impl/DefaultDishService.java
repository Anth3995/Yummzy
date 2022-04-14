package ua.com.yummzy.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.yummzy.document.Dish;
import ua.com.yummzy.dto.DishDto;
import ua.com.yummzy.exception.NotFoundException;
import ua.com.yummzy.mapper.DishMapper;
import ua.com.yummzy.repository.DishRepository;
import ua.com.yummzy.service.DishService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefaultDishService implements DishService {
    private final DishRepository dishRepository;
    private final DishMapper dishMapper;

    @Override
    @Transactional(readOnly = true)
    public DishDto getById(String id) {
        Dish dish = dishRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Dish with id " + id + " not found!"));
        return dishMapper.toDto(dish);
    }

    @Override
    public List<DishDto> getAllRandom(int size) {
        return dishRepository.findAllRandom(size).stream()
                .map(dishMapper::toDto)
                .collect(Collectors.toList());
    }
}
