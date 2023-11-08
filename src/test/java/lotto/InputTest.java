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
    @DisplayName("구매 금액 입력시 정상적인 문자열의 입력")
    @Test
    void normalPurchaseAmountInput() {
        Input input = new Input();

        assertThat(input.purchaseAmountInput("11000"))
                .isEqualTo(new ArrayList<>(Arrays.asList(11000)));
        assertThat(input.purchaseAmountInput("11234000"))
                .isEqualTo(new ArrayList<>(Arrays.asList(11234000)));
    }

    @DisplayName("구매 금액 입력시 숫자 이외의 문자를 포함한 문자열의 입력")
    @Test
    void nonNumericPurchaseAmountInput() {
        Input input = new Input();

        assertThatThrownBy(() -> input.purchaseAmountInput("!110000"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> input.purchaseAmountInput("+110000"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> input.purchaseAmountInput("-110000"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> input.purchaseAmountInput("110000@"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("구매 금액 입력시 비어있는 문자열 입력")
    @Test
    void emptyPurchaseAmountInput() {
        Input input = new Input();

        assertThatThrownBy(() -> input.purchaseAmountInput(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("구매 금액 입력시 1000으로 나눠 떨어지지 않는 문자열의 입력")
    @Test
    void notDivide1000PurchaseAmountInput() {
        Input input = new Input();

        assertThatThrownBy(() -> input.purchaseAmountInput("1234"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> input.purchaseAmountInput("123400"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력시 정상적인 문자열의 입력")
    @Test
    void normalBonusNumberInput() {
        Input input = new Input();

        assertThat(input.bonusNumberInput("11"))
                .isEqualTo(new ArrayList<>(Arrays.asList(11)));
        assertThat(input.bonusNumberInput("45"))
                .isEqualTo(new ArrayList<>(Arrays.asList(45)));
    }
    @DisplayName("보너스 번호 입력시 숫자 이외의 문자를 포함한 문자열의 입력")
    @Test
    void nonNumericBonusNumberInput() {
        Input input = new Input();

        assertThatThrownBy(() -> input.bonusNumberInput("!1"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> input.bonusNumberInput("1#"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> input.bonusNumberInput("-23"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> input.bonusNumberInput("+5"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("보너스 번호 입력시 비어있는 문자열의 입력")
    @Test
    void emptyBonusNumberInput() {
        Input input = new Input();

        assertThatThrownBy(() -> input.bonusNumberInput(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("보너스 번호 입력시 1 ~ 45 사이의 숫자가 아닌 문자열의 입력")
    @Test
    void notIn1To45BonusNumberInput() {
        Input input = new Input();

        assertThatThrownBy(() -> input.bonusNumberInput("46"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> input.bonusNumberInput("0"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> input.bonusNumberInput("100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력시 정상적인 문자열의 입력")
    @Test
    void normalWinningNumberInput() {
        Input input = new Input();

        assertThat(input.winningNumbersInput("1,2,3,4,5,6"))
                .isEqualTo(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(input.winningNumbersInput("10,14,18,22,26,30"))
                .isEqualTo(new ArrayList<>(Arrays.asList(10, 14, 18, 22, 26, 30)));
    }
    @DisplayName("당첨 번호 입력시 숫지 이외의 문자를 포함한 문자열의 입력")
    @Test
    void nonNumericWinningNumberInput() {
        Input input = new Input();

        assertThatThrownBy(() -> input.winningNumbersInput("!,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> input.winningNumbersInput("@,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("당첨 번호 입력시 쉼표의 구분이 적절하지 않은 문자열의 입력")
    @Test
    void illigalCommaWinningNumberInput() {
        Input input = new Input();

        assertThatThrownBy(() -> input.winningNumbersInput("1,2,3,4,5,6,"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> input.winningNumbersInput(",1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> input.winningNumbersInput("1,,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("당첨 번호 입력시 비어있는 문자열의 입력")
    @Test
    void emptyWinningNumberInput() {
        Input input = new Input();

        assertThatThrownBy(() -> input.winningNumbersInput(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("당첨 번호 입력시 1 ~ 45 사이의 숫자가 아닌 문자열의 입력")
    @Test
    void illigalWinningNumberInput() {
        Input input = new Input();

        assertThatThrownBy(() -> input.winningNumbersInput("0,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> input.winningNumbersInput("41,42,43,44,45,46"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
