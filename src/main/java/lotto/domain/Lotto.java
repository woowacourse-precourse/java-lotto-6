package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constants.LottoConstant;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != LottoConstant.LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(
                "[ERROR] 로또는 " + LottoConstant.LOTTO_NUMBER_SIZE + "개의 숫자로 이루어져야 합니다.");
        }
        if (existsDuplicateNumber(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    private boolean existsDuplicateNumber(List<Integer> numbers) {
        Set<Integer> numbersDeduplication = new HashSet<>(numbers);
        return numbers.size() != numbersDeduplication.size();
    }

    // TODO: 추가 기능 구현
}
