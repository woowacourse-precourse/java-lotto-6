package lotto.domain;

import java.util.List;

class SpecificLottoGenerator implements LottoGenerator {
    private final List<Integer> numbers;

    public SpecificLottoGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> generate() {
        return numbers;
    }
}