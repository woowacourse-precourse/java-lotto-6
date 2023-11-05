package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum LottoResult {
    FIRST_PRIZE(6, false, "6개 일치 (2,000,000,000원)", 2_000_000_000L),
    SECOND_PRIZE(5, true, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000L),
    THIRD_PRIZE(5, false, "5개 일치 (1,500,000원)", 1_500_000L),
    FOURTH_PRIZE(4, false, "4개 일치 (50,000원)", 50_000L),
    FIFTH_PRIZE(3, false, "3개 일치 (5,000원)", 5_000L),
    NO_PRIZE(0, false, "당첨 실패", 0L);
    private int matchCount;
    private boolean matchBonus;
    private String content;
    private long amount;

    LottoResult(int matchCount, boolean matchBonus, String content, long amount) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.content = content;
        this.amount = amount;
    }

    public static LottoResult calculateResult(Lotto lotto, LottoDraw lottoDraw) {
        int countMatches = (int) compareLottoAndLottoDraw(lotto, lottoDraw);
        boolean matchBonus = compareLottoAndBonusNumber(lotto, lottoDraw);

        return Arrays.stream(LottoResult.values())
                .filter(result -> result.matchCount == countMatches && result.matchBonus == matchBonus)
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
