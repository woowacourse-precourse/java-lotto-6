package lotto.domain;

import static lotto.utils.ConstantValues.LOTTO_NUMBERS_LENGTH;
import static lotto.utils.ConstantValues.MAX_LOTTO_NUMBER;
import static lotto.utils.ConstantValues.MAX_NUMBER_OF_LOTTOS;
import static lotto.utils.ConstantValues.MIN_LOTTO_NUMBER;
import static lotto.utils.ErrorMessages.INVALID_LOTTO_NUMBERS_LENGTH;
import static lotto.utils.ErrorMessages.LOTTO_NUMBER_DUPLICATION;
import static lotto.utils.ErrorMessages.LOTTO_NUMBER_OUT_OF_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.utils.LottoConstantValue;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto() {
        this.numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBERS_LENGTH);
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplication(numbers);
        validateRange(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_LENGTH) {
            throw new IllegalArgumentException(String.format(INVALID_LOTTO_NUMBERS_LENGTH, LOTTO_NUMBERS_LENGTH));
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATION);
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(
                        String.format(LOTTO_NUMBER_OUT_OF_RANGE, MIN_LOTTO_NUMBER, MAX_NUMBER_OF_LOTTOS));
            }
        }
    }

    public boolean doesHaveLottoNumber(int number) {
        return numbers.contains(number);
    }

    public int getSameCount(Lotto otherLotto) {
        Set<Integer> intersection = new HashSet<>(numbers);
        intersection.retainAll(new HashSet<>(otherLotto.numbers));
        return intersection.size();
    }

    @Override
    public String toString() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers.toString();
    }
}
