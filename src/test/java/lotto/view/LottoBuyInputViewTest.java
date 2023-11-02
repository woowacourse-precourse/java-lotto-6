package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.ErrorMessage;
import lotto.view.input.LottoBuyInputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.*;

class LottoBuyInputViewTest {

    private LottoBuyInputView lottoBuyInputView = new LottoBuyInputView();

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
    public void checkIsMultipleOfDenomination() {
        //given
        String input = "9200";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // when // then
        assertThatThrownBy(() -> lottoBuyInputView.requestLottoPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_AMOUNT.getMessage());
    }

    @ParameterizedTest(name = "{index}: 금액이 {0}이면 예외가 발생한다.")
    @DisplayName("Lotto의 금액이 0보다 크지 않으면 예외가 발생한다.")
    @ValueSource(strings = {"0","-1000","-1500"})
    public void checkIsValidLottoAmount(String input) {
        // given
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // when // then
        assertThatThrownBy(() -> lottoBuyInputView.requestLottoPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.AMOUNT_LESS_THAN_ZERO.getMessage());
    }

}