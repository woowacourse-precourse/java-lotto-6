package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WIN_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INVALID_INPUT_ERROR_MESSAGE = "[ERROR] 금액(숫자)을 입력해주세요.";
    private static final String INVALID_WIN_NUMBER_ERROR_MESSAGE = "[ERROR] 숫자만 입력해주세요.";
    private static final String INVALID_BONUS_NUMBER_ERROR_MESSAGE = "[ERROR] 숫자만 입력해주세요.";
    private static final String NUMBER_SPLITTER = ",";

    public static int inputMoney() {
        try {
            System.out.println(INPUT_MONEY_MESSAGE);
            String inputMoneyAmount = Console.readLine();
            int money = Integer.parseInt(inputMoneyAmount);
            return money;
        } catch (NumberFormatException e) {
            System.out.println(INVALID_INPUT_ERROR_MESSAGE);
            return inputMoney();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMoney();
        }
    }

    public static List<Integer> inputWinNumbers() {
        try {
            System.out.println(INPUT_WIN_NUMBER_MESSAGE);
            String inputWinNumbers = Console.readLine();
            List<Integer> winNumbers = Arrays.stream(inputWinNumbers.split(NUMBER_SPLITTER))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return winNumbers;
        } catch (NumberFormatException e) {
            System.out.println(INVALID_WIN_NUMBER_ERROR_MESSAGE);
            return inputWinNumbers();
        }
    }

    public static int inputBonusNumber() {
        try {
            String inputBonusNumber = Console.readLine();
            return Integer.parseInt(inputBonusNumber);
        } catch (NumberFormatException e) {
            System.out.println(INVALID_BONUS_NUMBER_ERROR_MESSAGE);
            return inputBonusNumber();
        }
    }
}
