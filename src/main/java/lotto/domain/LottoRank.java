package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIFTH(3, "3개 일치 (5,000원) - ", 5000),
    FOURTH(4, "4개 일치 (50,000원) - ", 50000),
    LOSE(0, "", 0),
    THIRD(5, "5개 일치 (1,500,000원) - ", 1500000),
    SECOND(5, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000),
    FIRST(6, "6개 일치 (2,000,000,000원) - ",2000000000);

    private final int count;
    private final String coment;
    private final int winningAmount;

    LottoRank(int count, String coment, int winningAmount) {
        this.count = count;
        this.coment = coment;
        this.winningAmount = winningAmount;
    }

    public static LottoRank from(int count, boolean hasBonus) {
        if (count >= 0 && count < 3) {
            return LOSE;
        }
        if (count == 5 && hasBonus) {
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(lottoRank -> !lottoRank.equals(SECOND) && lottoRank.count == count)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public String getComent() {
        return coment;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
