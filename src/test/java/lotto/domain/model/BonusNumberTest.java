package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.exception.lottonumbersexception.LottoNumbersInputException;
import lotto.exception.lottonumbersexception.NumbersErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {
    @DisplayName("보너스 번호를 정상적으로 입력한다.")
    @ParameterizedTest(name = "보너스 번호: {0}")
    @ValueSource(ints = {1, 2, 10, 19, 30, 45})
    void createBonusNumber(int number) {
        // when
        BonusNumber bonusNumber = new BonusNumber(number);

        // then
        assertEquals(number, bonusNumber.getNumber());
    }

    @DisplayName("보너스 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createBonusNumberByOutOfNumberRange() {
        // when & then
        assertThatThrownBy(() -> new BonusNumber(46))
                .isInstanceOf(LottoNumbersInputException.class)
                .hasMessage(NumbersErrorMessage.OUT_OF_NUMBERS_RANGE.getMessage());
    }
}