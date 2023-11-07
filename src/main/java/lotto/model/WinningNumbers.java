package lotto.model;

import lotto.utils.LottoExceptions;

import java.util.*;

public class WinningNumbers{

    private final List<Integer> numbers;
    private int bonusNumber;

    public WinningNumbers(String[] numbers) {
        List<Integer> validateNumbers = validateNumbers(numbers);
        this.numbers = validateNumbers;
    }

    public void setBonus(String bonusNumber){
        int validatedBonus = validateBonus(bonusNumber);
        this.bonusNumber = validatedBonus;
    }

    private void checkDuplicate(List<Integer> numbers){
        Set<Integer> duplicateTest = new HashSet<>(numbers);
        if (duplicateTest.size() < numbers.size()){
            throw new IllegalArgumentException(LottoExceptions.DuplicateError.getErrorMessage());
        }
    }

    private void isInRange(List<Integer> numbers){
        numbers.forEach(num ->{
            if (num > 45 || num < 1){
                throw new IllegalArgumentException(LottoExceptions.NotInRangeError.getErrorMessage());
            }
        });
    }

    private List<Integer> validateNumbers(String[] numbers){
        List<String> filteredNumbers = Arrays.stream(numbers)
                .filter(num -> num.matches("[0-9 ]+"))
                .toList();
        if (filteredNumbers.size() < numbers.length){
            throw new IllegalArgumentException(LottoExceptions.InputTypeError.getErrorMessage());
        }
        if (filteredNumbers.size() < 6){
            throw new IllegalArgumentException(LottoExceptions.InvalidCountError.getErrorMessage());
        }
        List<Integer> finalNumbers = filteredNumbers.stream().map(num -> Integer.parseInt(num.trim())).toList();
        isInRange(finalNumbers);
        checkDuplicate(finalNumbers);
        return finalNumbers;
    }

    private int validateBonus(String bonusNumber){
        if (!bonusNumber.matches("[0-9 ]+")){
            throw new IllegalArgumentException(LottoExceptions.InputTypeError.getErrorMessage());
        }
        int bonus = Integer.parseInt(bonusNumber.trim());
        if (bonus > 45 || bonus < 1) {
            throw new IllegalArgumentException(LottoExceptions.NotInRangeError.getErrorMessage());
        }
        for (int num : numbers){
            if (bonus == num){
                throw new IllegalArgumentException(LottoExceptions.DuplicateError.getErrorMessage());
            }
        }
        return bonus;
    }

    public int compare(Lotto lotto){
        int matchCount = 0;
        for (int winningNum : numbers){
            if (lotto.match(winningNum) > -1){
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean matchesBonus(Lotto lotto) {
        if (lotto.match(bonusNumber) != -1){
            return true;
        }
        return false;
    }
}
