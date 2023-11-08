package lib.enumeration;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoWinnerRule {
    FIRST(1, "6개 일치", 2000000000),
    SECOND(2, "5개 일치, 보너스 볼 일치", 30000000),
    THIRD(3, "5개 일치", 1500000),
    FOURTH(4, "4개 일치", 50000),
    FIFTH(5, "3개 일치", 5000);

    private final int index;
    private final String description;
    private final int prize;

    LottoWinnerRule(int index, String description, int prize) {
        this.index = index;
        this.description = description;
        this.prize = prize;
    }
    
    public int index() {
        return this.index;
    }

    public String description() {
        return this.description;
    }

    public int prize() {
        return this.prize;
    }

    private static final Map<Integer, LottoWinnerRule> BY_INDEX =
        Stream.of(values()).collect(Collectors.toMap(LottoWinnerRule::index, Function.identity()));

    public static LottoWinnerRule valueOfIndex(int index) {
        return BY_INDEX.get(index);
    }
}
