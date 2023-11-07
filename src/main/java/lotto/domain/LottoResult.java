package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum LottoResult {
    FIFTH_PLACE(5, 3, 5_000, Arrays.asList(true, false)),
    FOURTH_PLACE(4, 4, 50_000, Arrays.asList(true, false)),
    THIRD_PLACE(3, 5, 1_500_000, Arrays.asList(true, false)),
    SECOND_PLACE(2, 5, 30_000_000, Arrays.asList(true)),
    FIRST_PLACE(1, 6, 2_000_000_000, Arrays.asList(true, false));

    private final int rank;
    private final int lottoMatchCount;
    private final int lottoWinningAmount;
    private final List<Boolean> isMatchBonusNumber;

    LottoResult(int rank, int lottoMatchCount, int lottoWinningAmount, List<Boolean> isMatchBonusNumber) {
        this.rank = rank;
        this.lottoMatchCount = lottoMatchCount;
        this.lottoWinningAmount = lottoWinningAmount;
        this.isMatchBonusNumber = isMatchBonusNumber;
    }

    public static LottoResult getLottoResult(int lottoMatchCount, Boolean isMatchBonusNumber) {
        for (LottoResult result : values()) {
            if (result.lottoMatchCount == lottoMatchCount && result.isMatchBonusNumber.contains(isMatchBonusNumber)) {
                return result;
            }
        }
        return null;
    }

    public int getRank() {
        return rank;
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
