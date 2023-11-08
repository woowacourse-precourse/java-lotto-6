package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

import static lotto.constants.DomainConstants.*;

public enum LottoWinningAmount {

    NOTHING(0, (lottoNumberMatchCount, isBonusNumberMatch) ->
            LOTTO_MIN_NUMBER_MATCH_COUNT.getValue() <= lottoNumberMatchCount &&
            lottoNumberMatchCount < LOTTO_MIN_WINNING_NUMBER_MATCH_COUNT.getValue()),
    FIFTH(5_000, (lottoNumberMatchCount, isBonusNumberMatch) ->
            lottoNumberMatchCount == FIFTH_NUMBER_MATCH_COUNT.getValue()),
    FOURTH(50_000, (lottoNumberMatchCount, isBonusNumberMatch) ->
            lottoNumberMatchCount == FOURTH_NUMBER_MATCH_COUNT.getValue()),
    THIRD(1_500_000, (lottoNumberMatchCount, isBonusNumberMatch) ->
            lottoNumberMatchCount == THIRD_NUMBER_MATCH_COUNT.getValue() && !isBonusNumberMatch),
    SECOND(30_000_000, (lottoNumberMatchCount, isBonusNumberMatch) ->
            lottoNumberMatchCount == SECOND_NUMBER_MATCH_COUNT.getValue() && isBonusNumberMatch),
    FIRST(2_000_000_000, (lottoNumberMatchCount, isBonusNumberMatch) ->
            lottoNumberMatchCount == FIRST_NUMBER_MATCH_COUNT.getValue());


    private final static String NOT_FOUND_ERROR = "[ERROR] 우승 상금을 찾을 수 없습니다.";

    private final int value;
    private final BiPredicate<Integer, Boolean> match;

    LottoWinningAmount(int value, BiPredicate<Integer, Boolean> match) {
        this.value = value;
        this.match = match;
    }

    public static LottoWinningAmount of(final int lottoNumberMatchCount, final boolean isBonusNumberMatch) {
        return Arrays.stream(values())
                .filter(lottoWinningAmount -> lottoWinningAmount.match.test(lottoNumberMatchCount, isBonusNumberMatch))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_ERROR));
    }

    public int getValue() {
        return this.value;
    }
}
