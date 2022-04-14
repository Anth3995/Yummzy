package ua.com.yummzy.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "image")
public class DishImage {
    @Field(name = "position")
    private int position;
    @Field(name = "image_url")
    private String imageUrl;
}
