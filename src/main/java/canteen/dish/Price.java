package canteen.dish;

import java.math.BigDecimal;

public class Price {
    BigDecimal students;
    BigDecimal employees;
    BigDecimal guests;

    public Price(String students, String employees, String guests) {
        this.students = replaceComma(students);
        this.employees = replaceComma(employees);
        this.guests = replaceComma(guests);
    }

    public BigDecimal get(PriceClass priceClass) {
        return switch (priceClass) {
            case STUDENT -> this.students;
            case EMPLOYEE -> this.employees;
            case GUEST -> this.guests;
        };
    }

    private BigDecimal replaceComma(String price) {
        return new BigDecimal(price.replace(',', '.'));
    }

    @Override
    public String toString() {
        return "Price[" + students + ", " + employees + ", " + guests + ']';
    }
}
