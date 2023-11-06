package lotto.view;

import static lotto.view.InputValidator.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class InputView {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static int inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        return validateAndParseInput(Console.readLine());
    }

    public static ArrayList<Integer> inputWinningNumbers() {
        System.out.println(WINNING_NUMBERS_MESSAGE);
        return validateAndParseNumbersInput(Console.readLine());
    }

    public static int inputBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        return validateAndParseInput(Console.readLine());
    }
}
