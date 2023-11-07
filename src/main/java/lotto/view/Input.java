package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exceptionMessages.ExceptionMessages;

public class Input {
    private static final String INPUT_MONEY_GUIDE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_LOTTO_GUIDE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_GUIDE = "보너스 번호를 입력해 주세요.";
    private static final String INPUT_NUMERIC_PATTERN = "^[0-9]+$";
    private static final String SEPARATOR = ",";

    private Input() {}

    private static String input() {
        String input = Console.readLine();
        validateBlank(input);
        return input;
    }

    public static int inputMoneyGuide() {
        Output.print(INPUT_MONEY_GUIDE);
        String inputMoney = input();
        validateNumeric(inputMoney);
        return Integer.parseInt(inputMoney);
    }

    public static List<Integer> inputWinningNumbersGuide() {
        Output.print(INPUT_WINNING_LOTTO_GUIDE);
        String winningLotto = input();
        validateWinningLottoNumeric(winningLotto);
        return Arrays.stream(winningLotto.split(SEPARATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int inputBonusNumberGuide() {
        Output.print(INPUT_BONUS_NUMBER_GUIDE);
        String inputBonusNumber = input();
        validateNumeric(inputBonusNumber);
        return Integer.parseInt(inputBonusNumber);
    }

    private static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessages.EXCEPTION_BLANK_INPUT.getMessage());
        }
    }

    private static void validateNumeric(String input) {
        if (!input.matches(INPUT_NUMERIC_PATTERN)) {
            throw new IllegalArgumentException(ExceptionMessages.EXCEPTION_NUMERIC_INPUT.getMessage());
        }
    }

    private static void validateWinningLottoNumeric(String winningLotto) {
        for (String number : winningLotto.split(SEPARATOR)) {
            validateNumeric(number);
        }
    }
}
