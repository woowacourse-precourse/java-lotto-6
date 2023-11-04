package lotto.domain.lottery;

import lotto.domain.RandomNumberGenerator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto create() {
        List<Integer> randomNumbers = RandomNumberGenerator.generateLottoNumbers();
        return new Lotto(randomNumbers);
    }
}
