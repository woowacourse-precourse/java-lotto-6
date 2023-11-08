package lotto;

import lotto.util.ValidateWinningNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidateWinningNumberTest {

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinningNumberByOverSize() {

        Assertions.assertThatThrownBy(() -> ValidateWinningNumber.validateWinningNumber("1, 2, 3, 4, 5, 6, 7"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumberByDuplicatedNumber() {

        Assertions.assertThatThrownBy(() -> ValidateWinningNumber.validateWinningNumber("1, 2, 3, 4, 5, 5"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("당첨 번호에 1~45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createWinningNumberByNotRange() {

        Assertions.assertThatThrownBy(() -> ValidateWinningNumber.validateWinningNumber("1, 2, 3, 4, 5, 46"))
                .isInstanceOf(IllegalArgumentException.class);

    }

}
