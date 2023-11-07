package lotto;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    public void validateAmountUnit(int amount) {
        if (amount % 1000 != 0 || amount <= 0) {
            throw new IllegalStateException();
        }
    }

    public void validateWinNumberLength(String[] numbers) {
        if (numbers.length != 6) {
            throw new IllegalStateException();
        }
    }

    public List<Integer> validateWinNumberInt(String[] numbers) {
        List<Integer> numberList = new ArrayList<Integer>();
        for (String number : numbers) {
            int numberInt = Integer.parseInt(number);
            validateNumberRange(numberInt);
            numberList.add(numberInt);
        }
        return numberList;
    }

    public void validateWinNumberDuplicate(List<Integer> numbers) {
        if (!(numbers.size() == numbers.stream().distinct().count())) {
            throw new IllegalArgumentException();
        }
    }



    public void validateBonusNumberDuplicate(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
    public void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalStateException();
        }
    }
}
