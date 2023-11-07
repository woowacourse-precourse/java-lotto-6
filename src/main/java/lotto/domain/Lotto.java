package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final String LOTTO_NUMBER_SIZE_ERROR = "[ERROR] 당첨 번호는 6개 입력 가능합니다.";
    private static final String LOTTO_NUMBER_DUPLICATE_ERROR = "[ERROR] 중복된 숫자를 입력하셨습니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_SIZE_ERROR);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> duplicatedCheck = new HashSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            duplicatedCheck.add(numbers.get(i));
        }

        if (duplicatedCheck.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_ERROR);
        }
    }

    public void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_ERROR);
        }
    }

    public int countMatch(Lotto winningLotto) {
        return (int) numbers.stream().filter(winningLotto::containNumber).count();
    }

    public boolean containNumber(int number) {
        return numbers.contains(number);
    }
}
