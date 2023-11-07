package lotto.model;

import java.util.*;

public class WinningNumbers{

    private final List<Integer> numbers;
    private int bonusNumber;

    public WinningNumbers(String[] numbers) {
        List<Integer> finalNumbers = validateNumbers(numbers);
        this.numbers = finalNumbers;
    }

    public void setBonus(int bonusNumber){
        validateBonus(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
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
                .filter(num -> num.matches("[0-9]+"))
                .toList();
        if (filteredNumbers.size() < numbers.length){
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
        if (filteredNumbers.size() < 6){
            throw new IllegalArgumentException("6개의 숫자를 입력해주세요.");
        }
        List<Integer> finalNumbers = filteredNumbers.stream().map(Integer::parseInt).toList();
        isInRange(finalNumbers);
        checkDuplicate(finalNumbers);
        return finalNumbers;
    }

    private void validateBonus(List<Integer> numbers, int bonusNumber){
        if (bonusNumber > 45 || bonusNumber < 1) {
            throw new IllegalArgumentException("숫자는 1과 45사이의 수여야 합니다.");
        }
        for (int num : numbers){
            if (bonusNumber == num){
                throw new IllegalArgumentException("중복되는 숫자는 입력할 수 없습니다.");
            }
        }
    }

    public int compare(Lotto lotto){
        int matchCount = 0;
        for (int winningNum : numbers){
            if (lotto.match(winningNum) != -1){
                matchCount++;
            }
        }
        return matchCount;
    }

}
