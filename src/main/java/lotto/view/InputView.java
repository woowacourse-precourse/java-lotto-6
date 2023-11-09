package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;
import lotto.validator.NumericValidator;

public class InputView {

    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private static final String NUMBER_SPLIT_DELIMITER = ",";

    // 기본 생성자가 만들어지는 것을 막는다. (인스턴스화 방지용).
    private InputView() {
        throw new AssertionError();
    }

    public static long readPurchaseAmount() {
        return readWithRetry(() -> {
            System.out.println(INPUT_PURCHASE_AMOUNT);
            return readLongNumber();
        });
    }

    private static long readLongNumber() {
        final String strNumber = readLine();
        validateNumeric(strNumber);
        return Long.parseLong(strNumber);
    }

    public static List<Integer> readWinningNumbers() {
        return readWithRetry(() -> {
            System.out.println(System.lineSeparator() + INPUT_WINNING_NUMBER);
            return readNumbers();
        });
    }

    private static List<Integer> readNumbers() {
        final String[] splitNumbers = readLine().split(NUMBER_SPLIT_DELIMITER);

        validateNumeric(splitNumbers);

        return Stream.of(splitNumbers)
                .map(Integer::parseInt)
                .toList();
    }

    public static int readBonusNumber() {
        return readWithRetry(() -> {
            System.out.println(System.lineSeparator() + INPUT_BONUS_NUMBER);
            return readNumber();
        });
    }

    private static int readNumber() {
        final String strNumber = readLine();
        validateNumeric(strNumber);
        return Integer.parseInt(strNumber);
    }

    public static <T> T readWithRetry(final Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readWithRetry(supplier);
        }
    }

    private static String readLine() {
        return Console.readLine();
    }

    private static void validateNumeric(final String... strNumbers) {
        for (final String strNumber : strNumbers) {
            NumericValidator.validate(strNumber);
        }
    }
}
