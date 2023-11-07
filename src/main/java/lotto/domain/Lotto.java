package lotto.domain;

import static lotto.constants.ErrorMessages.DUPLICATES;
import static lotto.constants.ErrorMessages.INVALID_LOTTO_NUMBER_COUNT;

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

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT.getErrorMessage());
        }

        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if (distinctNumbers.size() != 6) {
            throw new IllegalArgumentException(DUPLICATES.getErrorMessage());
        }
    }

    // TODO: 추가 기능 구현
    public static Lotto generateLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lottoNumbers);
    }
    public List<Integer> getNumbers() {
        return numbers;
    }

}
