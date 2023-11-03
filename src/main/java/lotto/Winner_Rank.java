package lotto;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Winner_Rank {
    ONE("6개 일치 (2,000,000,000원)", 6, 2000000000 ),
    TWO("5개 일치, 보너스 볼 일치 (30,000,000원)",11, 30000000),
    THREE("5개 일치 (1,500,000원)",12, 1500000),
    FOUR("4개 일치 (50,000원)",4, 50000),
    FIVE("3개 일치 (5,000원)",3, 5000),
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
        return BY_PRICE.get(price);
    }
}
