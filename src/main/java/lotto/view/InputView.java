package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.LottoException;

public class InputView {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";


    public static String readPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        String amount = Console.readLine();
        validateIsEmptyInput(amount);
        return amount;
    }

    public static String readWinningNumbers() {
        System.out.println();
        System.out.println(WINNING_NUMBER_MESSAGE);
        String winningNumbers = Console.readLine();
        validateIsEmptyInput(winningNumbers);
        return winningNumbers;
    }

    public static String readBonusNumber() {
        System.out.println();
        System.out.println(BONUS_NUMBER_MESSAGE);
        String bonusNumber = Console.readLine();
        validateIsEmptyInput(bonusNumber);
        return bonusNumber;
    }

    private static void validateIsEmptyInput(String input){
        if (input.isEmpty()) {
            throw new IllegalArgumentException(LottoException.EMPTY_INPUT_ERROR_MESSAGE.getMessage());
        }
    }
}
