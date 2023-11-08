package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.response.Exception;
import lotto.constant.response.Information;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputView {
    private static final String SEPARATOR = ",";
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("^[0-9]*$");

    private void validateNullAndBlank(String input, Exception exception) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(Exception.ERROR_PREFIX.getMessage() + exception.getMessage());
        }
    }
    private void validateNumeric(String input, Exception exception) {
        if (!NUMERIC_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(Exception.ERROR_PREFIX.getMessage() + exception.getMessage());
        }
    }
    public int inputMoney() {
        System.out.println(Information.MONEY.getMessage());
        String input = Console.readLine();
        validateNullAndBlank(input, Exception.MONEY_NULL_BLANK);
        validateNumeric(input, Exception.MONEY_NUMERIC);
        return Integer.parseInt(input);
    }

    public List<Integer> inputWinningNumbers(){
        System.out.println(Information.WINNING_NUMBERS.getMessage());
        String input = Console.readLine();
        validateNullAndBlank(input, Exception.WINNING_NUMBERS_NULL_BLANK);
        return Arrays.stream(input.split(SEPARATOR))
                .peek(number -> validateNumeric(number, Exception.WINNING_NUMBERS_NUMERIC))
                .map(Integer::valueOf)
                .toList();
    }

    public Integer inputBonusNumber(){
        System.out.println(Information.BONUS_NUMBER);
        String input = Console.readLine();
        validateNullAndBlank(input, Exception.BONUS_NUMBER_NULL_BLANK);
        validateNumeric(input, Exception.BONUS_NUMBER_NUMERIC);
        return Integer.valueOf(input);
    }
}
