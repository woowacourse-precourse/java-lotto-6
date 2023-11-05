package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);

        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .toList();
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public boolean containsNumber(LottoNumber number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        validateNumbersCount(numbers);
        validateNumbersDuplication(numbers);
    }

    private static void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 번호를 입력해주세요");
        }
    }

    private static void validateNumbersDuplication(List<Integer> numbers) {
        long numberCount = numbers.stream()
                .distinct()
                .count();
        if(numberCount != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }
}
