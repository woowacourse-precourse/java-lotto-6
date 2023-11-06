package lotto.view.dto;

import java.util.ArrayList;
import java.util.List;
import lotto.view.exception.ExceptionMessage;

public class LottoWinningNumberCreateRequest {

    private static final String NUMBER_SEPARATOR = ",";

    private final List<Integer> numbers;

    public LottoWinningNumberCreateRequest(String winningNumbers) {
        String[] numbers = winningNumbers.split(NUMBER_SEPARATOR);

        this.numbers = new ArrayList<>();
        for (String number : numbers) {
            validateNumber(number);
            this.numbers.add(Integer.parseInt(number));
        }
    }

    private static void validateNumber(String number) throws IllegalArgumentException {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_FORMAT);
        }
    }


    public List<Integer> getNumbers() {
        return numbers;
    }
}
