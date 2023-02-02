package canteen.dish;

import canteen.CanteenService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DishFormatter {
    private final List<Dish> dishes;
    private final PriceClass priceClass;
    private final DietType dietType;

    public DishFormatter(LocalDate date, PriceClass priceClass, DietType dietType) {
        this.dishes = new CanteenService(date).getDishes();
        this.priceClass = priceClass;
        this.dietType = dietType;
    }

    public String format() {
        return Arrays.stream(DishType.values())
                .map(this::format)
                .collect(Collectors.joining());
    }

    private String format(DishType type) {
        var filtered = dishes.stream().filter(dish -> dish.type.equals(type))
                .filter(d -> d.mealContents.stream().anyMatch(this.dietType.contents::contains))
                .toList();

        if (filtered.isEmpty()) {
            return "";
        }

        var builder = new StringBuilder();
        builder.append("--- ").append(type).append(" ---").append("\n");

        filtered.forEach(d -> {
            var price = d.price.get(this.priceClass);
            builder.append("(%s) %s".formatted(price, d.name)).append("\n");
        });

        return builder.toString();
    }
}
