package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static util.TestUtil.setInput;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Console;

class InputViewTest {

    InputView inputView = new InputView();

    @AfterEach
    void cleanUp() {
        Console.close();
    }

    @Test
    void 정상적인_구매금액_입력() {
        // given
        int expect = 5000;

        setInput("5000\n");

        // when
        int amount = inputView.askPurchaseAmount();

        // then
        assertThat(amount).isEqualTo(expect);
    }

    @Test
    void 빈_문자열_입력_예외() {
        // given
        setInput("\n");

        // when & then
        assertThatThrownBy(() -> inputView.askPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정수로_변환할_수_없는_값_입력_예외() {
        // given
        setInput("우테코6기\n");

        // when & then
        assertThatThrownBy(() -> inputView.askPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
