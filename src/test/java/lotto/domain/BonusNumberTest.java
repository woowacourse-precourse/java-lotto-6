package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

    private WinningNumbers winningNumbers;

    @BeforeEach
    void setUp() {
        winningNumbers = WinningNumbers.of(List.of(3, 5, 11, 23, 31, 43));
    }

    @ParameterizedTest(name = "보너스 번호: {arguments}")
    @ValueSource(ints = {-1, 0, 46})
    void 보너스_번호의_숫자_범위가_올바르지_못하면_예외를_발생한다(int bonusNumber) {
        // when, then
        assertThatThrownBy(() -> new BonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "보너스 번호: {arguments}")
    @ValueSource(ints = {1, 2, 44, 45})
    void 보너스_번호의_숫자_범위가_올바르면_예외를_발생하지_않는다(int bonusNumber) {
        // when, then
        assertThatNoException()
                .isThrownBy(() -> new BonusNumber(bonusNumber, winningNumbers));
    }

    @ParameterizedTest(name = "보너스 번호: {arguments}")
    @ValueSource(ints = {3, 5, 11, 23, 31, 43})
    void 보너스_번호가_당첨_번호와_중복되면_예외를_발생한다(int bonusNumber) {
        // when, then
        assertThatThrownBy(() -> new BonusNumber(bonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "입력 번호: {0} / 보너스 번호: {1}")
    @CsvSource(value = {
            "45/true",
            "1/false",
            "2/false",
            "44/false"
    }, delimiter = '/')
    void 입력_번호와_보너스_번호와_일치_여부를_비교한다(int inputNumber, boolean matchBonus) {
        // given
        final int bonusNumberInput = 45;
        BonusNumber bonusNumber = new BonusNumber(bonusNumberInput, winningNumbers);

        // when, then
        assertThat(bonusNumber.match(inputNumber)).isEqualTo(matchBonus);
    }

}
