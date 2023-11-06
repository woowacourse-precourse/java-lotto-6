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
        while (true) {
            try {
                System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
                String purchaseAmount = Console.readLine();
                InputPurchaseAmountValidator.validatePurchaseAmount(purchaseAmount);
                System.out.println();
                return ConverterUtil.convertStringToInt(purchaseAmount);
            } catch (IllegalArgumentException e) {
            }
        }
    }

    public String inputWinningNumber() {
        while (true) {
            try {
                System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
                String winningNumber = Console.readLine();
                InputWinningNumberValidator.validateWinningNumber(winningNumber);
                System.out.println();
                return winningNumber;
            } catch (IllegalArgumentException e) {
            }
        }
    }

    public int inputBonusNumber() {

        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String bonusNumber = Console.readLine();
        InputWinningNumberValidator.validateBonusNumber(bonusNumber);
        System.out.println();
        return ConverterUtil.convertStringToInt(bonusNumber);
    }
}
