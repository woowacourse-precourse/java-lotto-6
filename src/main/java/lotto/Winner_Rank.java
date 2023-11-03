package lotto;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Winner_Rank {
    ONE("1등", 6, 2000000000 ),
    TWO("2등",11, 30000000),
    THREE("3등",12, 1500000),
    FOUR("4등",4, 50000),
    FIVE("5등",3, 5000),
    ZERO("꽝", 0, 0);

    private final String label;
    private final int number;
    private final int price;

    Winner_Rank(String label, int number, int price) {
        this.label = label;
        this.number = number;
        this.price = price;
    }

    public String label() {
        return label;
    }

    public int number() {
        return number;
    }

    public int price() {
        return price;
    }


    private static final Map<String, Winner_Rank> BY_LABEL =
            Stream.of(values()).collect(Collectors.toMap(Winner_Rank::label, Function.identity()));

    private static final Map<Integer, Winner_Rank> BY_NUMBER =
            Stream.of(values()).collect(Collectors.toMap(Winner_Rank::number, Function.identity()));

    private static final Map<Integer, Winner_Rank> BY_PRICE =
            Stream.of(values()).collect(Collectors.toMap(Winner_Rank::price, Function.identity()));

    public static Winner_Rank valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }

    public static Winner_Rank valueOfNumber(int number) {
        return BY_NUMBER.get(number);
    }

    public static Winner_Rank valueOfPrice(int price) {
        return BY_NUMBER.get(price);
    }
}
