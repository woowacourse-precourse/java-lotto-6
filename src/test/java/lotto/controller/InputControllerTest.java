package lotto.controller;

import lotto.converter.StringToInteger;
import lotto.model.PurchaseAmount;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.OutputViewImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class InputControllerTest {

    @DisplayName("잘못된 구입금액 입력시 다시 입력 받는다.")
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

    @DisplayName("잘못된 로또숫자 혹은 보너스 숫자 입력시 다시 입력 받는다.")
    @RepeatedTest(5)
    void repeatWinningNumberInput() {
        //given
        InputView inputView = new RandomInputViewImpl();
        OutputView outputView = new OutputViewImpl();
        StringToInteger stringToInteger = new StringToInteger();
        InputController inputController = new InputController(stringToInteger);

        //when
        WinningLotto winningLotto = inputController.getWinningLotto(inputView, outputView);

        //then
        assertThat(winningLotto).isNotNull();
    }


    static class RandomInputViewImpl implements InputView {
        private final Random random = new Random();

        @Override
        public String readPurchaseAmount() {
            if (random.nextBoolean()) {
                return "1000";
            }
            return "잘못된 구입금액";
        }

        @Override
        public String readWinningNumbers() {
            if (random.nextBoolean()) {
                return "1,2,3,4,5,6";
            }
            return "잘못된 로또 번호";
        }

        @Override
        public String readBonusNumber() {
            if (random.nextBoolean()) {
                return "7";
            }
            return "잘못된 보너스 숫자";
        }
    }
}
