package lotto.domain;

import java.util.Arrays;

public enum LottoWinningAmount {

    LOTTO_THREE_NUMBER_MATCH_WINNING_AMOUNT(3, false, 5_000),
    LOTTO_THREE_NUMBER_BONUS_NUMBER_MATCH_WINNING_AMOUNT(3, true, 5_000),
    LOTTO_FOUR_NUMBER_MATCH_WINNING_AMOUNT(4, false, 50_000),
    LOTTO_FOUR_NUMBER_BONUS_NUMBER_MATCH_WINNING_AMOUNT(4, true, 50_000),
    LOTTO_FIVE_NUMBER_MATCH_WINNING_AMOUNT(5, false, 1_500_000),
    LOTTO_FIVE_NUMBER_BONUS_NUMBER_MATCH_WINNING_AMOUNT(5, true, 30_000_000),
    LOTTO_SIX_NUMBER_MATCH_WINNING_AMOUNT(6, false, 2_000_000_000),
    LOTTO_SIX_NUMBER_BONUS_NUMBER_MATCH_WINNING_AMOUNT(6, true, 2_000_000_000);

    private final static String NOT_FOUND_ERROR = "[ERROR] 우승 상금을 찾을 수 없습니다.";
    private final int lottoNumberMatchCount;
    private final boolean isBonusNumberMatch;
    private final int value;

    LottoWinningAmount(int lottoNumberMatchCount, boolean isBonusNumberMatch, int value) {
        this.lottoNumberMatchCount = lottoNumberMatchCount;
        this.isBonusNumberMatch = isBonusNumberMatch;
        this.value = value;
    }

    public static LottoWinningAmount of(final int lottoNumberMatchCount, final boolean isBonusNumberMatch) {
        return Arrays.stream(values())
                .filter(lottoWinningAmount -> lottoWinningAmount.lottoNumberMatchCount == lottoNumberMatchCount
                        && lottoWinningAmount.isBonusNumberMatch == isBonusNumberMatch)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_ERROR));
    }

    public int getValue() {
        return this.value;
    }
}
