package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyLottoNumbers {
    private static final int MIN_IN_RANGE = 1;
    private static final int MAX_IN_RANGE = 45;
    private static final int EXACT_SIZE = 6;
    private static final int UNIQUE_NUMBER = 1;
    private List<Integer> myNumbers;
    private int bonusNumber;

    public MyLottoNumbers(String input) throws IllegalArgumentException {
        List<Integer> beForeCheck;
        beForeCheck = validateNumber(validateSplit(input));
        validateSize(beForeCheck);
        myNumbers = validateUnique(beForeCheck);
    }

    public void setBonusNumber(String bonusInput) throws IllegalArgumentException {
        try {
            this.bonusNumber = validateRange(Integer.parseInt(bonusInput));
            validateUniqueBonus(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ONLY_NUMBER.getMessage());
        }
    }

    public List<Integer> getMyNumbers() {
        return myNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private List<String> validateSplit(String input) throws IllegalArgumentException {
        try {
            return Arrays.asList(input.split(","));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_FORMAT.getMessage());
        }
    }

    private List<Integer> validateNumber(List<String> splitInput) throws IllegalArgumentException{
        try {
            List<Integer> splitInputNumbers = new ArrayList<>();
            for (String number : splitInput) {
                splitInputNumbers.add(validateRange(Integer.parseInt(number)));
            }
            return splitInputNumbers;
            } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ONLY_NUMBER.getMessage());
        }
    }

    private int validateRange(int number) throws IllegalArgumentException {
        if (number < MIN_IN_RANGE || number > MAX_IN_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_RANGE.getMessage());
        }
        return number;
    }

    private void validateSize(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != EXACT_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_SIZE.getMessage());
        }
    }

    private List<Integer> validateUnique(List<Integer> numbers) throws IllegalArgumentException {
        for (int n : numbers) {
            if (Collections.frequency(numbers,n)!=UNIQUE_NUMBER){
                throw new IllegalArgumentException(ErrorMessage.OVERLAP_NUMBER.getMessage());
            }
        }
        return numbers;
    }
    
    private void validateUniqueBonus(int bonus) throws IllegalArgumentException {
        if (myNumbers.contains(bonus)) {
            throw new IllegalArgumentException(ErrorMessage.OVERLAP_NUMBER.getMessage());
        }
    }
}
