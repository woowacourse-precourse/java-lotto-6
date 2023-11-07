package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countMatch(List<Integer> winningNumber){
        int result = 0;
        for (int number : numbers){
            if (winningNumber.contains(number)){
                result += 1;
            }
        }
        return result;
    }

    public boolean containBonusNUmber(int bonusNumber){
        return numbers.contains(bonusNumber);
    }


    // TODO: 추가 기능 구현
}
