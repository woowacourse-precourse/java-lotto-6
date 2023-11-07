package lotto.validator;

import lotto.domain.LottoWinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PlayerInputValidatorTest {

    @DisplayName("로또 입력값 오류 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"aaa", "-1000", "1500", "1000j"})
    void lottoErrorInput(String input) {
        assertThrows(IllegalArgumentException.class, () -> PlayerInputValidator.validateNumber(input));
    }

    @DisplayName("로또 당첨 입력값 오류 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,a"})
    void lottoWinningErrorInput(String input) {
        assertThrows(IllegalArgumentException.class, () -> LottoWinningNumber.getWinningNumbers(input));
    }
}