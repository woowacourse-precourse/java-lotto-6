package lotto.constant;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum LottoRank {

    THREE((winCount, bonus) -> winCount == 3, 5_000, "3개 일치 (%,d원)"),
    FOUR((winCount, bonus) -> winCount == 4, 50_000, "4개 일치 (%,d원)"),
    FIVE((winCount, bonus) -> winCount == 5 && bonus == 0, 1_500_000, "5개 일치 (%,d원)"),
    FIVE_BONUS((winCount, bonus) -> winCount == 5 && bonus == 1, 30_000_000, "5개 일치, 보너스 볼 일치 (%,d원)"),
    SIX((winCount, bonus) -> winCount == 6, 2_000_000_000, "6개 일치 (%,d원)"),
    NOTHING((winCount, bonus) -> false, 0, null);

    private final BiFunction<Integer, Integer, Boolean> checker;
    private final int prize;
    private final String string;

    LottoRank(BiFunction<Integer, Integer, Boolean> checker, int prize, String string) {
        this.checker = checker;
        this.prize = prize;
        this.string = string;
    }

    public static LottoRank findRank(int winningCount, int bonus) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.checker.apply(winningCount, bonus))
                .findFirst()
                .orElse(LottoRank.NOTHING);
    }

    public int getPrize() {
        return prize;
    }

    public String toString(int count) {
        return String.format(string, prize) + String.format(" - %d개", count);
    }

}
