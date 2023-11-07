package lotto.Domain;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

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
        if ((new HashSet<>(numbers)).size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public Optional<LottoRank> computeLottoRank(List<Integer> matchNumbers, int bonusNumber) {
        int match = (int) numbers.stream().filter(matchNumbers::contains).count();
        int bonus = (int) numbers.stream().filter(number -> number == bonusNumber).count();

        return LottoRank.computeLottoRank(match, bonus);
    }
}
