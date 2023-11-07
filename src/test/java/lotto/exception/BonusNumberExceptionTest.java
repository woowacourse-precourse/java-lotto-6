package lotto.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberExceptionTest {

    BonusNumberException bonusNumberException = new BonusNumberException();

    @DisplayName("보너스 번호에 문자가 들어가면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", " ", ""})
    void createBonusNumberByWord(String bonusNumber) {
        assertThatThrownBy(() -> bonusNumberException.word(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45 사이가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"0", "-1", "46"})
    void createBonusNumberByNotConditionalNumber(String bonusNumber) {
        assertThatThrownBy(() -> bonusNumberException.conditionalNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
