package canteen.dish;

public enum DishType {
    MAIN, SIDE, SOUP, DESERT;
    public static DishType fromString(String type) {
        return switch (type.charAt(0)) {
            case 'H' -> MAIN;
            case 'B' -> SIDE;
            case 'S' -> SOUP;
            case 'N' -> DESERT;
            default -> throw new IllegalStateException("Unexpected value: " + type.charAt(0));
        };
    }
}
