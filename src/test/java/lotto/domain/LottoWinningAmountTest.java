package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoWinningAmountTest {

    @ParameterizedTest
    @CsvSource(value = {"-2,false", "7,true", "12,false", "1_000,true", "223,false", "233,true"})
    void 로또_당첨_기준이_없을_경우_예외가_발생한다(int inputMatchCount, boolean inputBonusNumberMatch) {
        assertThatThrownBy(() -> LottoWinningAmount.of(inputMatchCount, inputBonusNumberMatch))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 우승 상금을 찾을 수 없습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0, false, 0", "0, true, 0",
            "1, false, 0", "1, true, 0",
            "2, false, 0", "2, true, 0",
            "3, false, 5_000", "3, true, 5_000",
            "4, false, 50_000", "4, true, 50_000",
            "5, false, 1_500_000", "5, false, 1_500_000",
            "6, false, 2_000_000_000", "6, true, 2_000_000_000"})
    void 기준에_일치한_상금이_있을시_상금을_반환한다(int inputMatchCount, boolean inputBonusNumberMatch, int expected) {
        assertThat(LottoWinningAmount.of(inputMatchCount, inputBonusNumberMatch).getValue())
                .isEqualTo(expected);
    }
}
