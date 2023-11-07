package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    boolean isBonus = false;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Number.LOTTO_SIZE.getNumber()) {
            throw new IllegalArgumentException();
        }
    }
    // TODO: 추가 기능 구현
    public int match(List<Integer> winningNumbers){
        int result = 0;
        for (int number : winningNumbers){
            if (numbers.contains(number))
                result++;
        }
        return result;
    }
    public boolean matchBonus(int number){
        return numbers.contains(number);
    }
}
