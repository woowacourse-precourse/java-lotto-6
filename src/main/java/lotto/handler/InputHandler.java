package lotto.handler;

import static lotto.message.SystemMessage.INPUT_PURCHASE_PRICE;
import static lotto.view.InputView.read;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputUtil;
import lotto.validator.InputValidator;
import lotto.view.OutputView;

public class InputHandler {

    private InputHandler() {
    }

    public static int setLottoPurchasePrice() {
        while (true) {
            try {
                String input = inputLottoPurchasePrice();

                InputValidator.validateIsNumber(input);
                int lottoPurchasePrice = InputUtil.parseInt(input);

                // 이 코드 떄문에 테스트에서 입력 에러 발생함..
                InputValidator.validateIsMultiplesOf1000(lottoPurchasePrice);
                return lottoPurchasePrice;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String inputLottoPurchasePrice() {
        OutputView.printMessage(INPUT_PURCHASE_PRICE);
        return read();
    }
}
