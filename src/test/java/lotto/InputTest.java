package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest {
    @DisplayName("구매 금액 입력시 비정상적인 문자열을 받는 경우")
    @Test
    void illigalPurchaseAmountInput() {
        Input input = new Input();

        // 정상적인 경우 테스트
        assertThat(input.purchaseAmountInput("11000"))
                .isEqualTo(new ArrayList<>(Arrays.asList(11000)));
        assertThat(input.purchaseAmountInput("11234000"))
                .isEqualTo(new ArrayList<>(Arrays.asList(11234000)));

        // 비정상적인 경우 테스트
        // 문자열에 숫자를 제외한 다른 문자가 있을 경우
        assertThatThrownBy(() -> input.purchaseAmountInput("!110000"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> input.purchaseAmountInput("+110000"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> input.purchaseAmountInput("-110000"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> input.purchaseAmountInput("110000@"))
                .isInstanceOf(IllegalArgumentException.class);
        // 문자열이 비어있는 경우
        assertThatThrownBy(() -> input.purchaseAmountInput(""))
                .isInstanceOf(IllegalArgumentException.class);
        // 구매 금액이 1000으로 나누어 떨어지지 않는 경우
        assertThatThrownBy(() -> input.purchaseAmountInput("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력시 비정상적인 문자열을 받는 경우")
    @Test
    void illigalBonusNumberInput() {
        Input input = new Input();

        // 정상적인 경우 테스트
        assertThat(input.bonusNumberInput("11"))
                .isEqualTo(new ArrayList<>(Arrays.asList(11)));
        assertThat(input.bonusNumberInput("45"))
                .isEqualTo(new ArrayList<>(Arrays.asList(45)));

        // 비정상적인 경우 테스트
        // 문자열에 숫자를 제외한 다른 문자가 있을 경우
        assertThatThrownBy(() -> input.bonusNumberInput("!1"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> input.bonusNumberInput("1#"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> input.bonusNumberInput("-23"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> input.bonusNumberInput("+5"))
                .isInstanceOf(IllegalArgumentException.class);
        // 문자열이 비어있는 경우
        assertThatThrownBy(() -> input.bonusNumberInput(""))
                .isInstanceOf(IllegalArgumentException.class);
        // 보너스 번호가 1 ~ 45 사이가 아닐 경우
        assertThatThrownBy(() -> input.bonusNumberInput("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력시 비정상적인 문자열을 받는 경우")
    @Test
    void illigalWinningNumberInput() {
        Input input = new Input();

        // 정상적인 경우 테스트
        assertThat(input.winningNumbersInput("1,2,3,4,5,6"))
                .isEqualTo(new ArrayList<>(Arrays.asList(1,2,3,4,5,6)));
        assertThat(input.winningNumbersInput("10,14,18,22,26,30"))
                .isEqualTo(new ArrayList<>(Arrays.asList(10,14,18,22,26,30)));

        // 비정상적인 경우 테스트
        // 문자열에 숫자와 쉼표를 제외한 다른 문자가 있을 경우
        assertThatThrownBy(() -> input.winningNumbersInput("!,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> input.winningNumbersInput("@,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
        // 쉼표 구분이 적절하게 이뤄지지 않은 경우
        assertThatThrownBy(() -> input.winningNumbersInput("1,2,3,4,5,6,"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> input.winningNumbersInput(",1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> input.winningNumbersInput("1,,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
        // 문자열이 비어있는 경우
        assertThatThrownBy(() -> input.winningNumbersInput(""))
                .isInstanceOf(IllegalArgumentException.class);
        // 당첨 번호가 1 ~ 45 사이가 아닐 경우
        assertThatThrownBy(() -> input.winningNumbersInput("0,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> input.winningNumbersInput("41,42,43,44,45,46"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
