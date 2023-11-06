package lotto.domain;

import java.util.List;

public class Numbers {
    private final List<Number> values;

    public Numbers(List<Integer> numbers) {
        this.values = numbers.stream()
                .sorted()
                .map(Number::new)
                .toList();
    }

    public Long getMatchCount(List<Integer> winningLottos) {
        return values.stream()
                .map(Number::getValue)
                .filter(winningLottos::contains)
                .count();
    }

    public Boolean isMatchBonusNumber(BonusNumber bonusNumber) {
        return values.stream()
                .map(Number::getValue)
                .anyMatch(bonusNumber::isMatchBonusNumber);
    }

    public List<Number> getValues() {
        return List.copyOf(values);
    }

}
