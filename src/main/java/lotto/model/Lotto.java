package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import lotto.exception.LottoException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoException.checkNumbersException(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public String sortNumbers() {
        return numbers.stream().sorted().map(String::valueOf).reduce((a,b) -> a + ", " + b).orElse("");
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public int countMatchNumbers(Lotto winningLotto) {
        return (int) numbers.stream().filter((Predicate<? super Integer>) winningLotto.numbers::contains).count();
    }
}
