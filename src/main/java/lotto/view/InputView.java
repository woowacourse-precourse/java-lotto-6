package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public static final String PROMPT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String PROMPT_BOUNS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String INPUT_MUST_BE_NUMBER = "[ERROR]입력값은 숫자만 가능합니다.";
    private static final String PROMPT_PURCHASE_AMOUNT = "구입 금액을 입력해 주세요.";
    private static final String NUMBER_PATTERN = "^[0-9]*$";

    public static int readPurchaseAmount() {
        System.out.println(PROMPT_PURCHASE_AMOUNT);
        String input = Console.readLine().trim();
        validateNumber(input);
        System.out.println();
        return Integer.parseInt(input);
    }

    public static List<Integer> readWinningNumbers() {
        System.out.println(PROMPT_WINNING_NUMBERS);
        String line = Console.readLine().trim();
        validateNumbers(line);
        System.out.println();
        return parseNumbers(line);
    }

    public static int readBonusNumber() {
        System.out.println(PROMPT_BOUNS_NUMBER);
        String line = Console.readLine().trim();
        validateNumber(line);
        System.out.println();
        return Integer.parseInt(line);
    }

    private static List<Integer> parseNumbers(String line) {
        return Arrays.stream(line.split(",")).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
    }

    private static void validateNumber(String input) {
        if (!input.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException(INPUT_MUST_BE_NUMBER);
        }
    }

    private static void validateNumbers(String input) {
        String[] numbers = input.split(",");
        for (String number : numbers) {
            validateNumber(number);
        }
    }
}
