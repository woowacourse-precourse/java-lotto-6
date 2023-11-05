package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static util.TestUtil.setInput;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Console;

class InputViewTest {

    InputView inputView = new InputView();

    @AfterEach
    void cleanUp() {
        Console.close();
    }

    @DisplayName("정상적인 구매금액을 입력한다.")
    @Test
    void inputPurchaseAmount() {
        // given
        int expect = 5000;

        setInput("5000\n");

        // when
        int amount = inputView.askPurchaseAmount();

        // then
        assertThat(amount).isEqualTo(expect);
    }

    @DisplayName("빈 문자열을 구매금액으로 입력한다.")
    @Test
    void inputEmptyPurchaseAmount() {
        // given
        setInput("\n");

        // when & then
        assertThatThrownBy(() -> inputView.askPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정수로 변환할 수 없는 값을 구매금액으로 입력하면 예외를 발생한다.")
    @Test
    void inputNonDigitPurchaseAmount() {
        // given
        setInput("우테코6기\n");

        // when & then
        assertThatThrownBy(() -> inputView.askPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
