package lotto;

import java.util.List;

public class LottoGenerator {
    private final List<Integer> numbers;
    int lottoCount;
    int bonus;


    public LottoGenerator(List<Integer> numbers, int lottoCount, int bonus) {
        validate(numbers);
        this.numbers = numbers;
        this.lottoCount = lottoCount;
        this.bonus = bonus;
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
