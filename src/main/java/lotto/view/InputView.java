package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.ConverterUtil;
import lotto.validator.InputPurchaseAmountValidator;
import lotto.validator.InputWinningNumberValidator;

public class InputView {
    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public int inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        String purchaseAmount = Console.readLine();
        System.out.println();
        InputPurchaseAmountValidator.validatePurchaseAmount(purchaseAmount);
        return ConverterUtil.convertStringToInt(purchaseAmount);
    }

    public String inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        String winningNumber = Console.readLine();
        System.out.println();
        InputWinningNumberValidator.validateWinningNumber(winningNumber);
        return winningNumber;
    }

    public int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String bonusNumber = Console.readLine();
        System.out.println();
        InputWinningNumberValidator.validateBonusNumber(bonusNumber);
        return ConverterUtil.convertStringToInt(bonusNumber);
    }
}
