package lotto;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Winner {
    THREE_PLACE(3, 5000),
    FOUR_PLACE(4, 50000),
    FIVE_PLACE(5, 1500000),
    FIVE_BONUS_PLACE(-5, 30000000),
    SIX_PLACE(6, 2000000000);

    private int match;
    private int prize;

    Winner(int match, int prize) {
        this.match = match;
        this.prize = prize;
    }
    public int getMatch() {
        return this.match;
    }

    public int getPrize() {
        return prize;
    }

    private static final Map<Integer, Winner> BY_MATCH =
            Stream.of(values()).collect(Collectors.toMap(Winner::getMatch, Function.identity()));

    public static Winner getByMatch(int match) {
        return BY_MATCH.get(match);
    }
}