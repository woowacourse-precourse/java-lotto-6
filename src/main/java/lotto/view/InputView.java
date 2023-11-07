package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;
import lotto.validator.TokenizedInputValidator;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public static final String USER_MONEY_INPUT_MSG = "구입금액을 입력해 주세요.";
    public static final String WINNING_NUMBER_INPUT_MSG = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_INPUT_MSG = "보너스 번호를 입력해 주세요.";
    public static final String SEPARATOR = ",";

    public static long getLottoPayment() {
        printMessage(USER_MONEY_INPUT_MSG);

        String money = Console.readLine();
        System.out.println();
        InputValidator.validateAmountFormatAndLimit(money);
        InputValidator.validateAmountUnitAndMinimum(Long.parseLong(money));
        return Long.parseLong(money);
    }

    public static List<Integer> getWinningNumber() {
        printMessage(WINNING_NUMBER_INPUT_MSG);

        String winningNumber = Console.readLine();
        System.out.println();
        return convertStringToIntegerList(winningNumber);
    }

    public static int getBonusNumber(List<Integer> lottoNumbers) {
        printMessage(BONUS_NUMBER_INPUT_MSG);

        String bonusNumber = Console.readLine();
        System.out.println();
        InputValidator.checkBonusNumber(lottoNumbers, bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    public static List<Integer> convertStringToIntegerList(String winningNumber) {
        TokenizedInputValidator.check(winningNumber.split(SEPARATOR));

        String[] numberStrings = winningNumber.split(SEPARATOR);
        List<Integer> numberList = new ArrayList<>();

        for (String numberStr : numberStrings) {
            numberList.add(Integer.parseInt(numberStr.trim()));
        }

        return numberList;
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
