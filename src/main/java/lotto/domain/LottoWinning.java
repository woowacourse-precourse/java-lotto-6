package lotto.domain;

import java.util.List;

public class LottoWinning {
    private final List<Integer> numbers;

    public LottoWinning(List<Integer> numbers){
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }
}
