package lotto.domain;

import java.util.List;

public class Winnings {

    private static final int MIN = 1;
    private static final int MAX = 45;

    private final Lotto wins;
    private final Integer bonus;

    public Winnings(List<Integer> wins, Integer bonus) {
        validate(wins, bonus);
        this.wins = new Lotto(wins);
        this.bonus = bonus;
    }

    public static void validate(List<Integer> wins, int bonus) {
        validateRange(bonus);
        validateDup(wins, bonus);
    }

    public static void validateRange(int bonus) {
        if (bonus < MIN || bonus > MAX) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateDup(List<Integer> wins, int bonus) {
        if (wins.contains(bonus)) {
            throw new IllegalArgumentException();
        }
    }
}
