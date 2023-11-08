package lotto.domain;

import java.util.Arrays;
import java.util.List;
import lotto.constant.ConstantNumber;

public enum LottoResult {
    NOTHING(0, 0, false, "0개 일치 -"),
    FIFTH(5000, 3, false, "3개 일치 (5,000원) - "),
    FOURTH(50000, 4, false, "4개 일치 (50,000원) - "),
    THIRD(1500000, 5, false, "5개 일치 (1,500,000원) - "),
    SECOND(30000000, 5, true, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(2000000000, 6, false, "6개 일치 (2,000,000,000원) - ");

    private final int prize;
    private final int count;
    private final boolean hasBonus;
    private final String message;

    LottoResult(int prize, int count, boolean hasBonus, String message) {
        this.prize = prize;
        this.count = count;
        this.hasBonus = hasBonus;
        this.message = message;
    }


    public static LottoResult calculate(Lotto lotto, WinningLotto winningLotto) {
        int count = (int) calculateCount(lotto, winningLotto.getLotto());
        boolean hasBonus = false;
        if(count == ConstantNumber.BONUS_COUNT) {
            hasBonus = lotto.containsNumber(winningLotto.getBonusNumber());
        }
        return calculateResult(count, hasBonus);
    }

    public static List<LottoResult> getValidLottoResults() {
        return Arrays.stream(LottoResult.values())
                .filter(result -> result != LottoResult.NOTHING)
                .toList();
    }

    private static long calculateCount(Lotto my, Lotto win) {
        List<Integer> winNumbers = win.getNumbers();
        return my.getNumbers().stream()
                .filter(winNumbers::contains)
                .count();
    }

    private static LottoResult calculateResult(int count, boolean hasBonus) {
        return Arrays.stream(values())
                .filter(result -> result.count == count)
                .filter(result -> result.hasBonus == hasBonus)
                .findAny()
                .orElse(NOTHING);
    }

    public long calculateTotalCount(List<LottoResult> results) {
        return results.stream()
                .filter(result -> result.count == this.count)
                .filter(rank -> rank.hasBonus == this.hasBonus)
                .count();
    }

    public static long calculateTotalPrize(List<LottoResult> results) {
        return results.stream()
                .mapToLong(LottoResult::getPrize)
                .sum();
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }
}
