package lotto.controller;

import lotto.converter.StringToInteger;
import lotto.model.PurchaseAmount;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.OutputViewImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class InputControllerTest {

    @DisplayName("잘못된 구입금액 입력시 예외를 던지고 다시 입력 받는다.")
    @RepeatedTest(5)
    void repeatPurchaseAmountInput() {
        //given
        InputView inputView = new RandomInputViewImpl();
        OutputView outputView = new OutputViewImpl();
        StringToInteger stringToInteger = new StringToInteger();
        InputController inputController = new InputController(stringToInteger);

        //when
        PurchaseAmount purchaseAmount = inputController.getPurchaseAmount(inputView, outputView);

        //then
        assertThat(purchaseAmount).isNotNull();
    }

    static class RandomInputViewImpl implements InputView {
        @Override
        public String readPurchaseAmount() {
            Random random = new Random();
            if (random.nextBoolean()) {
                return "1000";
            }
            return "잘못된 구입금액";
        }

        @Override
        public String readWinningNumbers() {
            return "1,2,3,4,5,6,7";
        }

        @Override
        public String readBonusNumber() {
            return "0";
        }
    }
}