package lotto.service;

import java.util.ArrayList;
import java.util.List;

import static lotto.values.ExceptionMessage.*;
import static lotto.values.LottoInformation.*;

public class SetWinningNumService {
    List<Integer> winningNumber;
    public SetWinningNumService() {
        winningNumber = new ArrayList<>();
    }
    public boolean checkException(String numbers) {
        if (!numbers.contains(PARTITION.getMessage()))
            throw new IllegalArgumentException(NOT_CORRECT_FORM.getMessage());

        String[] splitedNumbers = numbers.split(",");
        checkStringException(splitedNumbers);

        if (winningNumber.size() != TOTAL_LOTTO_NUMBER.getValue())
            throw new IllegalArgumentException(NOT_CORRECT_FORM.getMessage());

        return true;
    }
    private void checkStringException(String[] numbers) {
        if (numbers[0].equals(","))
            throw new IllegalArgumentException(NOT_CORRECT_FORM.getMessage());
        if (numbers[numbers.length - 1].equals(","))
            throw new IllegalArgumentException(NOT_CORRECT_FORM.getMessage());
        if (numbers.length != TOTAL_LOTTO_NUMBER.getValue())
            throw new IllegalArgumentException(NOT_LOTTO_TOTAL_NUMBER.getMessage());

        for (String number : numbers) {
            if (!number.matches(ONLY_NUMBER.getMessage()))
                throw new IllegalArgumentException(NOT_NUMBER.getMessage());
            int tempNumber = Integer.parseInt(number);
            checkNumberException(tempNumber);
        }
    }
    private void checkNumberException(int tempNumber) {
        if ((tempNumber < START_LOTTO_NUMBER.getValue())
                || (tempNumber > LAST_LOTTO_NUMBER.getValue()))
            throw new IllegalArgumentException(NOT_IN_NUMBER_RANGE.getMessage());
        if (winningNumber.contains(tempNumber))
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());

        winningNumber.add(tempNumber);
    }
    public List<Integer> getWinningNumber() {
        return winningNumber;
    }
}
