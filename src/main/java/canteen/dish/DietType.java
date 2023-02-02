package canteen.dish;

import java.util.List;

public enum DietType {
    VEGAN(List.of(DishContent.VEGAN)),
    VEGETARIAN(List.of(DishContent.VEGAN, DishContent.VEGETARIAN)),
    PESCETARIAN(List.of(DishContent.VEGAN, DishContent.VEGETARIAN, DishContent.SEAFOOD)),
    FULL(List.of(DishContent.values()));

    public final List<DishContent> contents;

    DietType(List<DishContent> contents) {
        this.contents = contents;
    }
}
