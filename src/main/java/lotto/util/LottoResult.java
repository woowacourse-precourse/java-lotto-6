package lotto.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import lotto.model.Lotto;
import lotto.model.LottoDraw;

public enum LottoResult {
    FIRST_PRIZE(6, "6개 일치 (2,000,000,000원)", 2_000_000_000L),
    SECOND_PRIZE(5, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000L),
    THIRD_PRIZE(5, "5개 일치 (1,500,000원)", 1_500_000L),
    FOURTH_PRIZE(4, "4개 일치 (50,000원)", 50_000L),
    FIFTH_PRIZE(3, "3개 일치 (5,000원)", 5_000L),
    NO_PRIZE(0, "당첨 실패", 0L);
    private int matchCount;
    private String content;
    private long amount;

    LottoResult(int matchCount, String content, long amount) {
        this.matchCount = matchCount;
        this.content = content;
        this.amount = amount;
    }


    public static LottoResult calculateResult(Lotto lotto, LottoDraw lottoDraw) {
        int countMatches = (int) compareLottoAndLottoDraw(lotto, lottoDraw);
        boolean matchBonus = compareLottoAndBonusNumber(lotto, lottoDraw);

        if (matchBonus && countMatches == 5) {
            return SECOND_PRIZE;
        } else if (!matchBonus && countMatches == 5) {
            return THIRD_PRIZE;
        }

        return Arrays.stream(LottoResult.values())
                .filter(result -> result.matchCount == countMatches)
                .findAny()
                .orElse(NO_PRIZE);

    }

    private static long compareLottoAndLottoDraw(Lotto lotto, LottoDraw lottoDraw) {
        // 시간복잡도 O(n)으로 바꾸기 위해 Set 이용
        Set<Integer> lottoDrawNumbers = new HashSet<>(lottoDraw.getNumbers());

        return lotto.getNumbers().stream()
                .filter(lottoDrawNumbers::contains)
                .count();
    }

    private static boolean compareLottoAndBonusNumber(Lotto lotto, LottoDraw lottoDraw) {
        return lotto.getNumbers().contains(lottoDraw.getBonusNumber());
    }

    public String getContent() {
        return content;
    }

    public long getAmount() {
        return amount;
    }
}
