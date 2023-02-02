import canteen.dish.DietType;
import canteen.dish.DishFormatter;
import canteen.dish.PriceClass;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        var output = new DishFormatter(LocalDate.now().plusDays(1), PriceClass.STUDENT, DietType.VEGETARIAN).format();
        System.out.println(output);
    }
}
