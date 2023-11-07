package lotto.model;

import java.util.HashMap;
import java.util.List;

public class WinningNumbers{

    private final List<Integer> numbers;
    private int bonusNumber;

    public WinningNumbers(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public void setBonus(int bonusNumber){
        validateBonus(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void checkDuplicate(List<Integer> numbers){
        HashMap<Integer, Integer> numberOfEach = new HashMap<>();
        for (int num : numbers){
            int repeats = numberOfEach.getOrDefault(num, 0);
            if (repeats >= 1){
                throw new IllegalArgumentException("중복되는 숫자는 입력할 수 없습니다.");
            }
            numberOfEach.put(num, repeats + 1);
        }
    }

    private void isInRange(List<Integer> numbers){
        numbers.forEach(num ->{
            if (num > 45 || num < 1){
                throw new IllegalArgumentException("숫자는 1과 45사이의 수여야 합니다.");
            }
        });
    }

    private void validateNumbers(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        isInRange(numbers);
        checkDuplicate(numbers);
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
