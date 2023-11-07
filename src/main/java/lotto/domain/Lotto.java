package lotto.domain;

import static lotto.constants.LottoConstant.LOTTO_NUMBER_SIZE;
import static lotto.constants.LottoConstant.MAXIMUM_LOTTO_NUMBER;
import static lotto.constants.LottoConstant.MINIMUM_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(
                    "[ERROR] 로또는 " + LOTTO_NUMBER_SIZE + "개의 숫자로 이루어져야 합니다.");
        }
        if (existsDuplicateNumber(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    private boolean existsDuplicateNumber(List<Integer> numbers) {
        Set<Integer> numbersDeduplication = new HashSet<>(numbers);
        return numbers.size() != numbersDeduplication.size();
    }

    public Lotto create() {
        return new Lotto(
            Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER,
                    LOTTO_NUMBER_SIZE));
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number.getNumber());
    }
}
