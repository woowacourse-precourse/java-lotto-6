package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.exception.NotDigitException;
import lotto.domain.exception.NotValidLottoNumberException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberConverterTest {

    private static final LottoNumberConverter LOTTO_NUMBER_CONVERTER = new LottoNumberConverter();

    @Test
    void convertWinningNumbers_당첨번호_문자열을_변환한다() {
        String winningNumbers = "1,2,3,4,5,45";
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 45);

        assertThat(LOTTO_NUMBER_CONVERTER.convertWinningNumbers(winningNumbers)).containsExactlyElementsOf(expected);
    }

    @Test
    void convertWinningNumbers_숫자_혹은_쉼표가_아닌_문자가_포함되어_있으면_예외가_발생한다() {
        String winningNumbers = "가,2,3,4,5,45";

        assertThatThrownBy(() -> {
            LOTTO_NUMBER_CONVERTER.convertWinningNumbers(winningNumbers);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자와 쉼표(,)만 입력해야 합니다.\n");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,5", "41,42,43,44,45,46"})
    void convertWinningNumbers_숫자가_1이상_45이하가_아니라면_예외가_발생한다(String bonusNumber) {
        assertThatThrownBy(() -> {
            LOTTO_NUMBER_CONVERTER.convertWinningNumbers(bonusNumber);
        }).isInstanceOf(NotValidLottoNumberException.class);
    }

    @Test
    void convertBonusNumber_보너스번호_문자열을_변환한다() {
        String bonusNumber = "45";
        int expected = 45;

        assertThat(LOTTO_NUMBER_CONVERTER.convertBonusNumber(bonusNumber)).isEqualTo(expected);
    }

    @Test
    void convertBonusNumber_숫자가_아닌_문자가_포함되어_있으면_예외가_발생한다() {
        String bonusNumber = "가";

        assertThatThrownBy(() -> {
            LOTTO_NUMBER_CONVERTER.convertBonusNumber(bonusNumber);
        }).isInstanceOf(NotDigitException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    void convertBonusNumber_숫자가_1이상_45이하가_아니라면_예외가_발생한다(String bonusNumber) {
        assertThatThrownBy(() -> {
            LOTTO_NUMBER_CONVERTER.convertBonusNumber(bonusNumber);
        }).isInstanceOf(NotValidLottoNumberException.class);
    }
}