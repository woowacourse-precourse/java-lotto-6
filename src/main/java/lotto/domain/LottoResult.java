package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum LottoResult {
    FIRST_PLACE(6, 2_000_000_000, Arrays.asList(true, false)),
    SECOND_PLACE(5, 30_000_000, Arrays.asList(true)),
    THIRD_PLACE(5, 1_500_000, Arrays.asList(true, false)),
    FOURTH_PLACE(4, 50_000, Arrays.asList(true, false)),
    FIFTH_PLACE(3, 5_000, Arrays.asList(true, false));

    private final int lottoMatchCount;
    private final int lottoWinningAmount;
    private final List<Boolean> isMatchBonusNumber;

    LottoResult(int lottoMatchCount, int lottoWinningAmount, List<Boolean> isMatchBonusNumber) {
        this.lottoMatchCount = lottoMatchCount;
        this.lottoWinningAmount = lottoWinningAmount;
        this.isMatchBonusNumber = isMatchBonusNumber;
    }

    public int getLottoMatchCount() {
        return lottoMatchCount;
    }

    public int getLottoWinningAmount() {
        return lottoWinningAmount;
    }

    public List<Boolean> getIsMatchBonusNumber() {
        return isMatchBonusNumber;
    }

}
