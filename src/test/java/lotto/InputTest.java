package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {
    @DisplayName("1000원 단위가 아닌 입력값은 오류를 발생한다")
    @Test
    void lottoBuyInputTest() {
        assertThatThrownBy(() -> new InputValidator().validateAndReturnLottoInput("1234"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new InputValidator().validateAndReturnLottoInput("123"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new InputValidator().validateAndReturnLottoInput("-123"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호는 중복된 값을 포함하면 안된다")
    @Test
    void winningNumberDuplicateTest() {
        assertThatThrownBy(() -> new InputValidator().validateAndReturnWinningNumber("1,1,1,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호는 당첨번호와 중복되면 안된다")
    @Test
    void bonusNumberDuplicateTest() {
        assertThatThrownBy(() -> new InputValidator().validateAndReturnBonusNumber("1" , List.of(Integer.valueOf("1,2,3,4,5,6"))))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
