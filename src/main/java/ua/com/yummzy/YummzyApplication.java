package ua.com.yummzy;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import ua.com.yummzy.document.Dish;
import ua.com.yummzy.document.DishImage;
import ua.com.yummzy.document.Restaurant;
import ua.com.yummzy.meta.Currency;
import ua.com.yummzy.repository.DishRepository;
import ua.com.yummzy.repository.RestaurantRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@SpringBootApplication
@RequiredArgsConstructor
@EnableMongoAuditing
public class YummzyApplication implements ApplicationRunner {
    private final RestaurantRepository restaurantRepository;
    private final DishRepository dishRepository;

    public static void main(String[] args) {
        SpringApplication.run(YummzyApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        Random random = new Random();
//        var restaurants = restaurantRepository.findAll();
//        var a = dishRepository.findAll();
//        List<Dish> c = new ArrayList<>();
//        for (Dish b : a) {
//            b.setRestaurant(restaurants.get(random.nextInt(restaurants.size())));
//            c.add(b);
//        }
//        dishRepository.saveAll(c);

//        var r1 = restaurantRepository.save(createRestaurant("1", "Vasy 1", "desc1", Set.of("123", "321"), Set.of("address1", "address2")));
//        var r2 = restaurantRepository.save(createRestaurant("2", "Vasy 2", "desc2", Set.of("123", "321"), Set.of("address1", "address2")));
//        var r3 = restaurantRepository.save(createRestaurant("3", "Vasy 3", "desc3", Set.of("123", "321"), Set.of("address1", "address2")));
//
//        dishRepository.save(createDish("d10", Currency.UAH, BigDecimal.valueOf(666), "desc10", r3));
//        dishRepository.save(createDish("d2", Currency.UAH, BigDecimal.valueOf(100), "desc2", r1));
//        dishRepository.save(createDish("d3", Currency.UAH, BigDecimal.valueOf(100), "desc3", r1));
//        dishRepository.save(createDish("d4", Currency.UAH, BigDecimal.valueOf(100), "desc4", r1));
//        dishRepository.save(createDish("d5", Currency.UAH, BigDecimal.valueOf(100), "desc5", r2));
//        dishRepository.save(createDish("d6", Currency.UAH, BigDecimal.valueOf(100), "desc6", r2));
//        dishRepository.save(createDish("d7", Currency.UAH, BigDecimal.valueOf(100), "desc7", r2));
//        dishRepository.save(createDish("d8", Currency.UAH, BigDecimal.valueOf(100), "desc8", r3));
    }

    private Restaurant createRestaurant(String name, String ownerName, String desc, Set<String> phones, Set<String> addresses) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(name);
        restaurant.setDescription(desc);
        restaurant.setPhones(phones);
        restaurant.setOwnerName(ownerName);
        restaurant.setAddresses(addresses);
        return restaurant;
    }

    private Dish createDish(String name, Currency currency, BigDecimal price, String desc, Restaurant r) {
        Dish dish = new Dish();
        dish.setName(name);
        dish.setCurrency(currency);
        dish.setPrice(price);
        dish.setDescription(desc);
        dish.setRestaurant(r);
        DishImage dishImageDocument1 = new DishImage();
        dishImageDocument1.setPosition(1);
        dishImageDocument1.setImageUrl("https://yummzy-dishes-images.s3.eu-central-1.amazonaws.com/dish4.jpg");
        DishImage imageDocument2 = new DishImage();
        imageDocument2.setPosition(2);
        imageDocument2.setImageUrl("https://yummzy-dishes-images.s3.eu-central-1.amazonaws.com/dish1.jpeg");
        dish.setImages(List.of(dishImageDocument1, imageDocument2));
        return dish;
    }
}
