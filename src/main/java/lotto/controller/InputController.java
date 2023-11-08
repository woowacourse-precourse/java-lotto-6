package lotto.controller;

import static lotto.util.Validator.bonusNumberValidator;
import static lotto.util.Validator.lottoPurchaseAmountValidator;
import static lotto.util.Validator.lottoNumberValidator;

import lotto.dto.LottoDto;
import lotto.view.InputView;

public class InputController {
    private static String inputLottoPurchaseAmount;
    private static String inputWinningNumbers;
    private static String inputBonusNumber;

    public static void inputLottoPurchaseAmount(LottoDto lottoDto) {
        boolean validFlag;
        do {
            validFlag = lottoPurchaseAmountValidator(getInputPurchase());
        }
        while (!validFlag);
        lottoDto.setLottoPurchaseAmount(inputLottoPurchaseAmount);
    }

    private static String getInputPurchase() {
        return inputLottoPurchaseAmount = InputView.inputLottoPurchaseAmount();
    }

    public static void inputWinningNumbers(LottoDto lottoDto) {
        boolean validFlag;
        do {
            validFlag = lottoNumberValidator(getInputWinning());
        }
        while (!validFlag);
        lottoDto.setWinningNumbers(inputWinningNumbers);
    }

    private static String getInputWinning() {
        return inputWinningNumbers = InputView.inputWinningNumbers();
    }

    public static void inputBonusNumber(LottoDto lottoDto) {
        boolean validFlag;
        do {
            validFlag = bonusNumberValidator(getInputBonus(), lottoDto.getWinningNumbers());
        }
        while (!validFlag);
        lottoDto.setBonusNumber(inputBonusNumber);
    }

    private static String getInputBonus() {
        return inputBonusNumber = InputView.inputBonusNumber();
    }
}
