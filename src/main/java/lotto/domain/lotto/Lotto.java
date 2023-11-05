package lotto.domain.lotto;

import static lotto.domain.lotto.LottoNumberConfig.NUMBER_COUNT;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if(validateSize(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자여야 합니다.");
        }
        if(validateDuplication(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 없어야 합니다.");
        }
    }

    private boolean validateSize(List<Integer> numbers) {
        return  (numbers.size() != NUMBER_COUNT.getValue());
    }

    private boolean validateDuplication(List<Integer> numbers) {
        return (numbers.stream()
                .distinct()
                .count() != NUMBER_COUNT.getValue());
    }


}
