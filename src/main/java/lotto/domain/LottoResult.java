package lotto.domain;

import java.util.Arrays;

public enum LottoResult {

    THREE(3, false, 5000),
    FOUR(4, false, 50000),
    FIVE(5, false, 1500000),
    FIVE_BONUS(5, true, 30000000),
    SIX(6, false, 2000000000);

    private final int count;
    private final boolean validBonus;
    private final int prize;

    LottoResult(int count, boolean validBonus, int prize) {
        this.count = count;
        this.validBonus = validBonus;
        this.prize = prize;
    }

    public static LottoResult findByCountAndValidBonus(int count, boolean bonus) {
        if (count != 5) {
            return Arrays.stream(LottoResult.values()).filter(lottoResult -> lottoResult.getCount() == count).findAny()
                    .orElse(null);
        }
        return Arrays.stream(LottoResult.values())
                .filter(lottoResult -> lottoResult.getCount() == count && lottoResult.isValidBonus() == bonus)
                .findAny().orElse(null);
    }

    public int getCount() {
        return count;
    }

    public boolean isValidBonus() {
        return validBonus;
    }

    public int getPrize() {
        return prize;
    }

}