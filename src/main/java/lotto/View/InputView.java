package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.exception.ExceptionMessage;
import lotto.service.validator.Validator;

public class InputView {
    private static Validator validator = new Validator();
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBERS_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static List<Integer> winningNumberList;

    public static Integer getAmount() {
        int amount = getAmountFromUser();
        validator.validateAmount(amount);
        return amount;
    }

    public static Integer getAmountFromUser() {
        System.out.println(MONEY_INPUT_MESSAGE);
        try {
            return Integer.valueOf(Console.readLine());
        } catch (NumberFormatException e) {
            ExceptionMessage.typeException();
            return getAmountFromUser();
        }
    }

    public static List<Integer> getWinningNumbers(String winnigNumber) {
        String[] result = winnigNumber.split(",");
        winningNumberList = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            winningNumberList.add(conventToInt(result[i]));
        }
        return winningNumberList;
    }

    private static int conventToInt(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            ExceptionMessage.typeException();
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> getWinningNumbersFromUser() {
        System.out.println(WINNING_NUMBERS_INPUT_MESSAGE);
        return getWinningNumbers(Console.readLine());
    }

    public static Integer getBonusNumberFromUser() {
        System.out.println(BONUS_NUMBERS_INPUT_MESSAGE);
        return Integer.valueOf(Console.readLine());
    }
}
