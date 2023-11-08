package lotto.constant;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoPrize {
    THREE_MATCH(3, 5000, "3개 일치 (5,000원) - "),
    FOUR_MATCH(4, 50000, "4개 일치 (50,000원) - "),
    FIVE_MATCH(5, 1500000, "5개 일치 (1,500,000원) - "),
    FIVE_MATCH_WITH_BONUS(0, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX_MATCH(6, 2000000000, "6개 일치 (2,000,000,000원) - ");
    private final int matchedNumber;
    private final int prize;
    private final String message;
    private static final Map<Integer, String> MAP = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(LottoPrize::getMatchedNumber, LottoPrize::name))
    );

    LottoPrize(int matchedNumber, int prize, String message) {
        this.matchedNumber = matchedNumber;
        this.prize = prize;
        this.message = message;
    }

    public int getMatchedNumber() {
        return matchedNumber;
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }

    public static LottoPrize findByMatchedNumber(int matchedNumber) {
        return LottoPrize.valueOf(MAP.get(matchedNumber));
    }

    public static List<LottoPrize> findAllLottoPrize() {
        return Arrays.stream(values()).toList();
    }
}
