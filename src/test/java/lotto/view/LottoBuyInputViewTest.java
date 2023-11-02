package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.ErrorMessage;
import lotto.view.input.LottoBuyInputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.*;

class LottoBuyInputViewTest {

    LottoBuyInputView lottoBuyInputView = new LottoBuyInputView();

    @AfterEach
    void tearDown(){
        Console.close();
    }

    @Test
    @DisplayName("사용자에게 구입할 Lotto 금액은 1000원 단위이다.")
    public void requestLottoPurchaseAmount() {
        // given
        String input = "98000";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // when
        int amount = lottoBuyInputView.requestLottoPurchaseAmount();
        // then
        boolean isResult = amount % 1000 == 0;
        assertThat(isResult).isTrue();
    }

    @Test
    @DisplayName("Lotto의 금액이 1000원 단위가 아니면 예외가 발생한다.")
    public void requestLottoPurchaseAmountException() {
        //given
        String input = "9200";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // when // then
        assertThatThrownBy(() -> lottoBuyInputView.requestLottoPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_AMOUNT.getMessage());
    }

}