package lotto.vo;

import lotto.values.CorrectNumber;

import java.util.ArrayList;
import java.util.List;

import static lotto.values.ExceptionMessage.*;
import static lotto.values.LottoInformation.*;

public class WinningNumber {
    private final List<Integer> numbers;

    public WinningNumber(String winningNumbers) {
        numbers = new ArrayList<>();
        checkException(winningNumbers);
    }

    public void checkException(String winningNumbers) {
        String[] splitedNumbers = winningNumbers.split(PARTITION.getMessage());
        checkStringException(splitedNumbers);

        if (splitedNumbers.length != TOTAL_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(NOT_CORRECT_FORM.getMessage());
        }
    }

    private void checkStringException(String[] numbers) {
        if (numbers[0].equals(PARTITION.getMessage())) {
            throw new IllegalArgumentException(NOT_CORRECT_FORM.getMessage());
        }
        if (numbers[numbers.length - 1].equals(PARTITION.getMessage())) {
            throw new IllegalArgumentException(NOT_CORRECT_FORM.getMessage());
        }
        if (numbers.length != TOTAL_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(NOT_LOTTO_TOTAL_NUMBER.getMessage());
        }

        for (String number : numbers) {
            if (!number.matches(ONLY_NUMBER.getMessage())) {
                throw new IllegalArgumentException(NOT_NUMBER.getMessage());
            }
            int tempNumber = Integer.parseInt(number);
            checkNumberException(tempNumber);
        }
    }

    private void checkNumberException(int tempNumber) {
        if ((tempNumber < START_LOTTO_NUMBER.getValue())
                || (tempNumber > LAST_LOTTO_NUMBER.getValue())) {
            throw new IllegalArgumentException(NOT_IN_NUMBER_RANGE.getMessage());
        }
        if (numbers.contains(tempNumber)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
        }

        numbers.add(tempNumber);
    }

    public boolean checkDuplication(int num){
        return numbers.contains(num);
    }

    public CorrectNumber selectPlace(Lotto lotto) {
        int count = lotto.countWinning(this.numbers);

        for(CorrectNumber c : CorrectNumber.values()){
            if(c.getValue() == count) return c;
        }
        return null;
    }
}
