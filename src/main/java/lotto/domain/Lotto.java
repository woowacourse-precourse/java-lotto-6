package lotto.domain;

import static lotto.constant.LottoConstant.LOTTO_END_NUMBER;
import static lotto.constant.LottoConstant.LOTTO_SIZE;
import static lotto.constant.LottoConstant.LOTTO_START_NUMBER;
import static lotto.exception.Message.LOTTO_OUT_OF_SIZE_EXCEPTION;
import static lotto.exception.Message.NUMBER_DUPLICATION_EXCEPTION;
import static lotto.exception.Message.NUMBER_OUT_OF_RANGE_EXCEPTION;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        validateNumber(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (outOfSize(numbers)) {
            throw new IllegalArgumentException(LOTTO_OUT_OF_SIZE_EXCEPTION);
        }
    }

    private boolean outOfSize(List<Integer> numbers) {
        return numbers.size() != LOTTO_SIZE;
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = uniqueLottoNumbers(numbers);
        if (isDuplicated(uniqueNumbers)) {
            throw new IllegalArgumentException(NUMBER_DUPLICATION_EXCEPTION);
        }
    }

    private boolean isDuplicated(Set<Integer> uniqueNumbers) {
        return uniqueNumbers.size() != LOTTO_SIZE;
    }

    private void validateNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateRange(number);
        }
    }

    private void validateRange(Integer number) {
        if (outOfRange(number)) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE_EXCEPTION);
        }
    }

    private boolean outOfRange(Integer number) {
        return number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER;
    }

    public boolean isOverlapping(int bonusNumber) {
        return this.numbers.stream().anyMatch(number -> isSame(bonusNumber, number));
    }

    private boolean isSame(int bonusNumber, Integer number) {
        return bonusNumber == number;
    }

    public int compare(Lotto winnerLotto) {
        List<Integer> totalLottoNumbers = mergeLottos(winnerLotto);
        Set<Integer> uniqueLottoNumbers = uniqueLottoNumbers(totalLottoNumbers);
        return countOfMatch(totalLottoNumbers, uniqueLottoNumbers);
    }

    private List<Integer> mergeLottos(Lotto winnerLotto) {
        List<Integer> totalNumbers = new ArrayList<>();
        totalNumbers.addAll(winnerLotto.numbers);
        totalNumbers.addAll(this.numbers);
        return totalNumbers;
    }

    private Set<Integer> uniqueLottoNumbers(List<Integer> totalLottoNumbers) {
        return new HashSet<>(totalLottoNumbers);
    }

    private int countOfMatch(List<Integer> totalLottoNumbers, Set<Integer> uniqueLottoNumbers) {
        return totalLottoNumbers.size() - uniqueLottoNumbers.size();
    }

    public boolean hasBonus(int bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
