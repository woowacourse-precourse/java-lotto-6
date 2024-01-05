package lotto.view;

import java.util.Arrays;
import java.util.List;
import lotto.constant.errorMessage.input.InputExceptionStatus;
import lotto.constant.errorMessage.exception.CustomNumberFormatAmountException;
import lotto.constant.errorMessage.exception.CustomNullPointAmountException;
import lotto.view.reader.Reader;

public class InputView {

    private static final String PRINT_READ_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PRINT_READ_WINNING_NUMBERS_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String PRINT_READ_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String DELIMITER_COMMA = ",";

    private final Reader reader;

    public InputView(final Reader reader) {
        this.reader = reader;
    }

    public int readAmount() {
        System.out.println(PRINT_READ_AMOUNT_MESSAGE);
        return convertToNumber(reader.readLine());
    }

    public List<Integer> readWinningNumbers() {
        System.out.println(PRINT_READ_WINNING_NUMBERS_MESSAGE);
        return convertToSplitNumbers(reader.readLine());
    }

    public int readBonusNumber() {
        System.out.println(PRINT_READ_BONUS_NUMBER_MESSAGE);
        return convertToNumber(reader.readLine());
    }

    private int convertToNumber(final String input) {
        try {
            return Integer.parseInt(checkNumberIsNull(input));
        } catch (NumberFormatException e) {
            throw new CustomNumberFormatAmountException(InputExceptionStatus.READ_IS_NOT_NUMERIC);
        }
    }

    private String checkNumberIsNull(final String input) {
        try {
            return input.trim();
        } catch (NullPointerException e) {
            throw new CustomNullPointAmountException(InputExceptionStatus.READ_IS_NULL);
        }
    }

    private List<Integer> convertToSplitNumbers(final String input) {
        return Arrays.stream(splitWithComma(checkNumberIsNull(input)))
                .map(this::convertToNumber)
                .toList();
    }

    private static String[] splitWithComma(final String input) {
        return input.split(DELIMITER_COMMA);
    }
}
