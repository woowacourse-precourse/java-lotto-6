package lotto.domain;

import static lotto.validator.LottoValidator.validateLotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLotto(numbers);
        numbers = sort(numbers);
        this.numbers = numbers;
    }

    private List<Integer> sort(List<Integer> list) {
        return list.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    public int getMatchLottoNumber(WinningLotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto::isContain)
                .count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
