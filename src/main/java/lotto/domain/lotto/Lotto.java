package lotto.domain.lotto;

import lotto.domain.Result;
import lotto.dto.LottoDto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        this.validateIsSixLength(numbers);
        this.validateIsDuplicate(numbers);
    }

    private void validateIsSixLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개 여야함");
        }
    }

    private void validateIsDuplicate(List<Integer> numbers) {
        Set<Integer> duplicateValidator = new HashSet<>();
        numbers.forEach(number -> {
            if (!duplicateValidator.add(number)) {
                throw new IllegalArgumentException("로또 번호는 중복 불가능");
            }
        });
    }

    public Result getResult(WinningLotto winningLotto) {
        return winningLotto.evaluateLottoResult(numbers);
    }

    public LottoDto toDto() {
        return new LottoDto(numbers);
    }
}
