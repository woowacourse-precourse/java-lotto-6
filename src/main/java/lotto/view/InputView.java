package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputValidator;

public class InputView {
    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String askPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
        String inputPurchaseAmount = Console.readLine();

        return inputPurchaseAmount;
    }

    public String askWinnigNumbers() {
        System.out.println(WINNING_NUMBERS_INPUT_MESSAGE);
        String inputWinnigNumbers = Console.readLine();

        return inputWinnigNumbers;
    }

    public String askBonusNumber() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        String inputBonusNumber = Console.readLine();

        return inputBonusNumber;
    }
}

