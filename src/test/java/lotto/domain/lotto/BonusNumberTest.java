package lotto.domain.lotto;

import static org.junit.jupiter.api.Assertions.*;

import lotto.exception.domain.bonusnumber.BonusNumberFormatException;
import lotto.exception.domain.bonusnumber.BonusNumberRangeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("보너스 숫자 검증 테스트")
class BonusNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "4", "45"})
    @DisplayName("1~45 범위의 숫자를 입력했을 때 보너스 넘버가 정상적으로 생성된다.")
    void testValidBonusNumber(String inputNum) {
        BonusNumber bonusNumber = BonusNumber.create(inputNum);

        assertEquals(Integer.parseInt(inputNum), bonusNumber.getNumber());
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "invalidNum", "1,2"})
    @DisplayName("숫자가 아닌 경우를 입력했을 때 예외 발생")
    void testInValidFormat(String invalidInput) {
        assertThrows(BonusNumberFormatException.class, () -> {
            BonusNumber.create(invalidInput);
        });
    }

    @Test
    @DisplayName("숫자가 1~45 사이의 수가 아닌 경우 예외 발생")
    void testOutOfRange() {
        assertThrows(BonusNumberRangeException.class, () -> {
            BonusNumber.create("46");
        });
    }
}