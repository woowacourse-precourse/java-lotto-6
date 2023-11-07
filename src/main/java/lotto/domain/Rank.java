package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
    EMPTY(0, 0, false, ""),
    FIFTH(5_000, 3, false, "3개 일치 (5,000원) - "),
    FOURTH(50_000, 4, false, "4개 일치 (50,000원) - "),
    THIRD(1_500_000, 5, false, "5개 일치 (1,500,000원) - "),
    SECOND(30_000_000, 5, true, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(2_000_000_000, 6, false, "6개 일치 (2,000,000,000원) - ");

    public static final int BONUS_CONTAIN_CONDITION = 5;

    private int prize;
    private int matchLottoCount;
    private final boolean bonus;
    private String message;

    Rank(int prize, int matchLottoCount, boolean bonus, String message) {
        this.prize = prize;
        this.matchLottoCount = matchLottoCount;
        this.bonus = bonus;
        this.message = message;
    }

    public static Rank calculateRank(Lotto lotto, WinningNumber winningNumber) {

        final int matchCount = matchCount(lotto, winningNumber.getLotto().getNumber());

        boolean bonus = false;
        if (matchCount == BONUS_CONTAIN_CONDITION) {
            bonus = lotto.hasMatchedNumber(winningNumber.getBonusNumber());
        }

        return rank(matchCount, bonus);


    }

    private static int matchCount(Lotto lotto, List<Integer> numbers) {
        return (int) numbers.stream()
                .filter(lotto::hasMatchedNumber)
                .count();
    }

    private static Rank rank(int matchCount, boolean bonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchLottoCount == matchCount)
                .filter(rank -> rank.bonus == bonus)
                .findAny()
                .orElse(EMPTY);
    }

    public static List<Rank> getValidRanks() {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.EMPTY)
                .collect(Collectors.toList());
    }

    public static long calculateEarning(List<Rank> results) {
        return results.stream()
                .mapToLong(Rank::getPrize)
                .sum();
    }

    public long calculateCount(List<Rank> results) {
        return results.stream()
                .filter(rank -> rank.matchLottoCount == this.matchLottoCount)
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
