package lotto.model;

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
            throw new IllegalArgumentException("숫자 중복");
        }
    }

    private void isInRange(List<Integer> numbers){
        numbers.forEach(num ->{
            if (num > 45 || num < 1){
                throw new IllegalArgumentException("숫자는 1과 45사이의 수여야 합니다.");
            }
        });
    }

    private List<Integer> validateNumbers(String[] numbers){
        List<String> filteredNumbers = Arrays.stream(numbers)
                .filter(num -> num.matches("[0-9 ]+"))
                .toList();
        if (filteredNumbers.size() < numbers.length){
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
        if (filteredNumbers.size() < 6){
            throw new IllegalArgumentException("6개의 숫자를 입력해주세요.");
        }
        List<Integer> finalNumbers = filteredNumbers.stream().map(num -> Integer.parseInt(num.trim())).toList();
        isInRange(finalNumbers);
        checkDuplicate(finalNumbers);
        return finalNumbers;
    }

    private int validateBonus(String bonusNumber){
        if (!bonusNumber.matches("[0-9 ]+")){
            throw new IllegalArgumentException("only numbers");
        }
        int bonus = Integer.parseInt(bonusNumber.trim());
        if (bonus > 45 || bonus < 1) {
            throw new IllegalArgumentException("숫자는 1과 45사이의 수여야 합니다.");
        }
        for (int num : numbers){
            if (bonus == num){
                throw new IllegalArgumentException("중복되는 숫자는 입력할 수 없습니다.");
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
