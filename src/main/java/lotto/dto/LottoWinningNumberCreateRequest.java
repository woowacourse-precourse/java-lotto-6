package lotto.dto;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.ExceptionMessage;

public class LottoWinningNumberCreateRequest {

    private static final String NUMBER_SEPARATOR = ",";

    private List<Integer> numbers;

    public LottoWinningNumberCreateRequest(String winningNumbers) {
        String[] numbers = winningNumbers.split(NUMBER_SEPARATOR);

        this.numbers = new ArrayList<>();
        for (String stringNumber : numbers) {
            int number = validateAndParseNumber(stringNumber);
            this.numbers.add(number);
        }
    }

    private static int validateAndParseNumber(String stringNumber) {
        int number;
        try {
            number = Integer.parseInt(stringNumber);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_FORMAT);
        }
        return number;
    }


    public List<Integer> getNumbers() {
        return numbers;
    }
}
