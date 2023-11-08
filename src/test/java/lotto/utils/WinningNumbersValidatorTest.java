package lotto.utils;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumbersValidatorTest {

    @DisplayName("당첨 번호의 시작 혹은 끝에 쉼표를 넣으면 예외가 발생한다.")
    @Test
    void 당첨번호_쉼표_테스팅() {
        String startWithComma = ",1,2,3";
        assertThatThrownBy(() -> WinningNumbersValidator.validate(startWithComma))
                .isInstanceOf(IllegalArgumentException.class);
        String endWithComma = "1,2,3,";
        assertThatThrownBy(() -> WinningNumbersValidator.validate(endWithComma))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 각 요소는 모두 숫자여야 한다.")
    @Test
    void 당첨번호_각요소_숫자_테스팅() {
        String winningNumbers = "a,2,3,4,5,6";
        String[] digits = winningNumbers.split(",");
        assertThatThrownBy(() -> WinningNumbersValidator.validDigitIsInt(digits[0]))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatNoException().isThrownBy(() ->WinningNumbersValidator.validDigitIsInt(digits[1]));
    }
}
