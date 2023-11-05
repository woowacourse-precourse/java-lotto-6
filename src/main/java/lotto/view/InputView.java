package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.CommaParser;
import lotto.validator.InputValidator;

public class InputView {

    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";

    public static int getPurchaseMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        String input = Console.readLine();

        try {
            InputValidator.validateEmpty(input);
            return InputValidator.validateNumber(input);
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            return getPurchaseMoney();
        }
    }

    public static List<Integer> getLottoNumbers() {
        System.out.println(INPUT_LOTTO_MESSAGE);
        String input = Console.readLine();

        try {
            List<String> splitByCommas = CommaParser.parse(input);

            return splitByCommas.stream()
                    .map(number -> {
                        InputValidator.validateEmpty(number);
                        return InputValidator.validateNumber(number);
                    })
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            return getLottoNumbers();
        }
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}