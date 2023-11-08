package lotto;

import java.util.List;

public class LottoGenerator {
    int lottoCount;
    int bonus;
    private final List<Integer> numbers;

    public LottoGenerator(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void generator(){

    }

    private void checkWinning(){

    }
}
