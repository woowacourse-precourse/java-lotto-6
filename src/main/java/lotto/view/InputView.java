package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.LottoError;
import lotto.exception.LottoValidationException;

public class InputView {

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = readLine();
        validateNotEmpty(input);
        return parseToInteger(input);
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = readLine();
        validateNotEmpty(input);
        return parseWinningNumbers(input);
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = readLine();
        validateNotEmpty(input);
        return parseToInteger(input);
    }

    private static String readLine() {
        return Console.readLine();
    }

    private static void validateNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new LottoValidationException(LottoError.EMPTY_OR_NULL_INPUT.toString());
        }
    }

    private static int parseToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new LottoValidationException(LottoError.INVALID_NUMBER.toString());
        }
    }

    private static List<Integer> parseWinningNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(InputView::parseToInteger)
                .collect(Collectors.toList());
    }
}
