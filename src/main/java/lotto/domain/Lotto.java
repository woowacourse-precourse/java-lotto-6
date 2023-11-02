package lotto.domain;

import java.util.List;

import static lotto.impl.oneTo45LottoGame.ONE_TO_45_NUMBER_COUNT;

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

    public int getFiveNumberWinningResult(List<Integer> consumerFiveNumber) {
        return numbers.stream()
                .filter(consumerFiveNumber::contains)
                .toList()
                .size();
    }

    public int getBonusNumberWinningResult(int consumerBonusNumber) {
        return numbers.get(ONE_TO_45_NUMBER_COUNT - 1) == consumerBonusNumber ? 1 : 0;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
