package lotto.controller;

import static lotto.util.Validator.bonusNumberValidator;
import static lotto.util.Validator.lottoPurchaseAmountValidator;
import static lotto.util.Validator.lottoWinningNumberValidator;

import lotto.dto.InputDto;
import lotto.view.InputView;

public class InputController {
    private static String inputLottoPurchaseAmount;
    private static String inputWinningNumbers;
    private static String inputBonusNumber;

    public static void inputLottoPurchaseAmount(InputDto inputDto) {
        while (lottoPurchaseAmountValidator(getInputPurchase())) {
            inputDto.setLottoPurchaseAmount(inputLottoPurchaseAmount);
        }
    }

    private static String getInputPurchase() {
        return inputLottoPurchaseAmount = InputView.inputLottoPurchaseAmount();
    }

    public static void inputWinningNumbers(InputDto inputDto) {
        while (lottoWinningNumberValidator(getInputWinning())) {
            inputDto.setWinningNumbers(inputWinningNumbers);
        }
    }

    private static String getInputWinning() {
        return inputWinningNumbers = InputView.inputWinningNumbers();
    }

    public static void inputBonusNumber(InputDto inputDto) {
        while (bonusNumberValidator(getInputBonus(), inputDto.getWinningNumbers())) {
            inputDto.setBonusNumber(inputBonusNumber);
        }
    }

    private static String getInputBonus() {
        return inputBonusNumber = InputView.inputBonusNumber();
    }
}
