package lotto.controller;

import static lotto.util.Validator.lottoPurchaseAmountValidator;

import lotto.dto.InputDto;
import lotto.view.InputView;

public class InputController {
    private static String inputLottoPurchaseAmount;

    public static void InputLottoPurchaseAmount(InputDto inputDto) {
        while (lottoPurchaseAmountValidator(getInputPurchase())) {
            inputDto.setLottoPurchaseAmount(inputLottoPurchaseAmount);
        }
    }

    private static String getInputPurchase() {
        return inputLottoPurchaseAmount = InputView.inputLottoPurchaseAmount();
    }
}
