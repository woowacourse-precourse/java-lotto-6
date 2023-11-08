package lotto.domain;

import static lotto.constant.NumberConstants.BONUS_COUNT;

import java.util.Arrays;
import java.util.List;

public enum LottoRank {

    EMPTY(0, 0, false, "0개 일치 - "),
    FIFTH(5000, 3, false, "3개 일치 (5,000원) - "),
    FOURTH(50000, 4, false, "4개 일치 (50,000원) - "),
    THIRD(1500000, 5, false, "5개 일치 (1,500,000원) - "),
    SECOND(30000000, 5, true, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(2000000000, 6, false, "6개 일치 (2,000,000,000원) - ");

    private final int prize;
    private final int matchCount;
    private final boolean bonus;
    private final String message;

    LottoRank(int prize, int matchCount, boolean bonus, String message) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.bonus = bonus;
        this.message = message;
    }

    public static LottoRank calculate(Lotto lotto, WinningNumber winningNumber) {
        int matchCount = findMatchCount(lotto, winningNumber.getLotto().numbers());

        boolean bonus = false;
        if (matchCount == BONUS_COUNT) {
            bonus = lotto.hasMatchedNumber(winningNumber.getBonusNumber());
        }

        return findRank(matchCount, bonus);
    }

    private static int findMatchCount(Lotto lotto, List<Integer> numbers) {
        return (int) numbers.stream()
                .filter(lotto::hasMatchedNumber)
                .count();
    }

    private static LottoRank findRank(int matchCount, boolean bonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .filter(rank -> rank.bonus == bonus)
                .findAny()
                .orElse(EMPTY);
    }

    public static List<LottoRank> findValidRanks() {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.EMPTY)
                .toList();
    }

    public static long calculate(List<LottoRank> results) {
        return results.stream()
                .mapToLong(LottoRank::getPrize)
                .sum();
    }

    public long calculateCount(List<LottoRank> results) {
        return results.stream()
                .filter(rank -> rank.matchCount == this.matchCount)
                .filter(rank -> rank.bonus == this.bonus)
                .count();
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }

}
