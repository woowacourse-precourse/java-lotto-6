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

    private Input() {}

    public static int inputMoneyGuide() {
        System.out.println(INPUT_MONEY_GUIDE);
        String money = Console.readLine();
        validateBlank(money);
        validateNumeric(money);
        return Integer.parseInt(money);
    }

    public static List<Integer> inputWinningNumbersGuide() {
        System.out.println(INPUT_WINNING_LOTTO_GUIDE);
        String winningLotto = Console.readLine();
        validateBlank(winningLotto);
        validateWinningLottoNumeric(winningLotto);
        return Arrays.stream(winningLotto.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int inputBonusNumberGuide() {
        System.out.println(INPUT_BONUS_NUMBER_GUIDE);
        String bonusNumber = Console.readLine();
        validateBlank(bonusNumber);
        validateNumeric(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    private static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessages.EXCEPTION_BLANK_INPUT.getMessage());
        }
    }

    private static void validateNumeric(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException(ExceptionMessages.EXCEPTION_NUMERIC_INPUT.getMessage());
        }
    }

    private static void validateWinningLottoNumeric(String winningLotto) {
        for (String number : winningLotto.split(",")) {
            validateNumeric(number);
        }
    }
}
