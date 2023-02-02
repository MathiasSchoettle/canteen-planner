package canteen.dish;

import java.util.Arrays;

public enum DishContent {
    BEEF("R"),
    PORK("S"),
    POULTRY("G"),
    SEAFOOD("F"),
    VEGETARIAN("V"),
    VEGAN("VG"),
    VITAL("MV"),
    JURA_DISTL("J"),
    ORGANIC("B"),
    BIOLAND("BL"),
    ALCOHOL("A");
    public final String shorthand;
    DishContent(String shorthand) {
        this.shorthand = shorthand;
    }

    public static DishContent fromShorthand(String shorthand) {
        return Arrays.stream(DishContent.values())
                .filter(type -> type.shorthand.equals(shorthand))
                .findFirst().orElseThrow();
    }
}