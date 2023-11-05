package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputTest {
    @DisplayName("숫자 입력 시 숫자가 아닌 값이 들어오면 예외가 발생한다.")
    @Test
    void stringValueToIntegerValue() {
        String input = "abcde";
        assertThatThrownBy(() -> Integer.parseInt(input))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("구매 금액 입력 시 1000 단위로 나누어 떨어지는지 검사한다.")
    @Test
    void purchaseAmountCanDivide1000() {
        String input = "99999";
        int rest = Integer.parseInt(input) % 1000;
        assertThat(rest).isNotEqualTo(0);
    }

    @DisplayName("보너스 번호가 1 ~ 45 사이의 정수인지 검사한다.")
    @Test
    void isBonusNumberInOneToFortyFive() {
        int bonusNumber1 = 37;
        int bonusNumber2 = 49;
        int bonusNumber3 = -4;

        assertThat(!(bonusNumber1 < 1 || bonusNumber1 > 45)).isEqualTo(true);
        assertThat(!(bonusNumber2 < 1 || bonusNumber2 > 45)).isEqualTo(false);
        assertThat(!(bonusNumber3 < 1 || bonusNumber3 > 45)).isEqualTo(false);

    }

}