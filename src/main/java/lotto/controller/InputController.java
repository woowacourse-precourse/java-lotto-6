package lotto.controller;

import static lotto.util.Validator.bonusNumberValidator;
import static lotto.util.Validator.lottoPurchaseAmountValidator;
import static lotto.util.Validator.lottoWinningNumberValidator;

import lotto.dto.LottoDto;
import lotto.view.InputView;

public class InputController {
    private static String inputLottoPurchaseAmount;
    private static String inputWinningNumbers;
    private static String inputBonusNumber;

    public static void inputLottoPurchaseAmount(LottoDto lottoDto) {
        while (lottoPurchaseAmountValidator(getInputPurchase())) {
            lottoDto.setLottoPurchaseAmount(inputLottoPurchaseAmount);
        }
    }

    private static String getInputPurchase() {
        return inputLottoPurchaseAmount = InputView.inputLottoPurchaseAmount();
    }

    public static void inputWinningNumbers(LottoDto lottoDto) {
        while (lottoWinningNumberValidator(getInputWinning())) {
            lottoDto.setWinningNumbers(inputWinningNumbers);
        }
    }

    private static String getInputWinning() {
        return inputWinningNumbers = InputView.inputWinningNumbers();
    }

    public static void inputBonusNumber(LottoDto lottoDto) {
        while (bonusNumberValidator(getInputBonus(), lottoDto.getWinningNumbers())) {
            lottoDto.setBonusNumber(inputBonusNumber);
        }
    }

    private static String getInputBonus() {
        return inputBonusNumber = InputView.inputBonusNumber();
    }
}
