package lotto.domain.strategy;

import java.util.Arrays;
import java.util.List;

import lotto.domain.Lotto;

public class ManualIssuanceStrategy implements IssuableStrategy {

    private final String numbers;

    public ManualIssuanceStrategy(final String numbers) {
        this.numbers = numbers;
    }

    @Override
    public Lotto issue() {
        return new Lotto(convertToSortedNumbers());
    }

    private List<Integer> convertToSortedNumbers() {
        return Arrays.stream(this.numbers.split(","))
                .map(Integer::parseInt)
                .sorted()
                .toList();
    }

}
