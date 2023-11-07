package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.stream.IntStream;

public enum Rank {
    //  일치 개수, 보너스 일치 여부, 나누는 값
    FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원) - %d개"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원) - %d개"),
    FOURTH(4, false, 50_000, "4개 일치 (50,000원) - %d개"),
    FIFTH(3, false, 5_000, "3개 일치 (5,000원) - %d개");

    private final int count;
    private final boolean isBonus;
    private final int winningAmount;
    private final String message;

    Rank(int count, boolean isBonus, int winningAmount, String message) {
        this.count = count;
        this.isBonus = isBonus;
        this.winningAmount = winningAmount;
        this.message = message;
    }

    public static Rank matchRank(Lotto lotto, WinningLotto winningLotto) {
        int count = (int) IntStream.range(0, lotto.size())
                .filter(index -> winningLotto.getLotto().contain(lotto.get(index)))
                .count();

        boolean isBonus = IntStream.range(0, lotto.size())
                .anyMatch(index -> winningLotto.getBonusNumber().getBonus() == lotto.get(index));

        return matchRank(count, isBonus);
    }

    private static Rank matchRank(int matchCount, boolean isBonus) {
        for (Rank rank : values()) {
            if (rank.count == matchCount && rank.isBonus == isBonus) {
                return rank;
            }
        }

        return null;
    }

    public static EnumMap<Rank, Integer> createEnumMap() {
        return new EnumMap<>(Rank.class) {{
            Arrays.stream(Rank.values())
                    .forEach(value -> put(value, 0));
        }};
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public String getMessage(int count) {
        return String.format(message, count);
    }
}
