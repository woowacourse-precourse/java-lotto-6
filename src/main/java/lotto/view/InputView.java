package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import static lotto.ErrorMessage.*;

public class InputView {
    private static final String PURCHASE_MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String WINNING_NUMBERS_INPUT_DELIMITER = ",";

    private final Supplier<String> reader;

    public InputView(Supplier<String> reader) {
        this.reader = reader;
    }

    public int readPurchaseMoney() {
        System.out.println(PURCHASE_MONEY_INPUT_MESSAGE);

        try {
            return Integer.parseInt(reader.get());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PURCHASE_MONEY_INPUT_ERROR.getMessage());
        }
    }

    public List<Integer> readWinningNumbers() {
        System.out.println();
        System.out.println(WINNING_NUMBERS_INPUT_MESSAGE);

        String readLine = reader.get();
        validateEndWithDelimiter(readLine);

        return toWinningNumbers(readLine);
    }

    private void validateEndWithDelimiter(String readLine) {
        if (readLine.endsWith(WINNING_NUMBERS_INPUT_DELIMITER)) {
            throw new IllegalArgumentException(
                    String.format(END_WITH_DELIMITER_ERROR.getMessage(), WINNING_NUMBERS_INPUT_DELIMITER));
        }
    }

    public List<Integer> toWinningNumbers(String readLine) {
        try {
            return Arrays.stream(readLine.split(WINNING_NUMBERS_INPUT_DELIMITER))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    String.format(WINNING_NUMBERS_INPUT_ERROR.getMessage(), WINNING_NUMBERS_INPUT_DELIMITER));
        }
    }
}
