package canteen.dish;

import java.util.Arrays;
import java.util.List;

public class Dish {
    public String name;
    public DishType type;
    public List<DishContent> mealContents;
    public Price price;

    private Dish() {}

    public static Dish fromString(String line) {
        var dish = new Dish();
        var items = line.split(";");

        dish.type = DishType.fromString(items[2]);
        // remove allergen info from name
        dish.name = items[3].split("\\(")[0].trim();
        dish.mealContents = Arrays.stream(items[4].split(",")).map(DishContent::fromShorthand).toList();
        dish.price = new Price(items[6], items[7], items[8]);

        return dish;
    }

    @Override
    public String toString() {
        return "(" + name + ", " + type + ", " + mealContents + ", " + price + ')';
    }
}
