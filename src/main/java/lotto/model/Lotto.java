package lotto.model;

import static lotto.util.Constants.LOTTO_SIZE;
import static lotto.util.Constants.MAX_LOTTO_NUM;
import static lotto.util.Constants.MIN_LOTTO_NUM;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.message.ExceptionMessage;
import lotto.util.LottoUtil;
import lotto.validator.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> numbersCopy = new ArrayList<>(numbers);
        LottoUtil.sortByAsc(numbersCopy);
        this.numbers = numbersCopy;
    }

    private void validate(List<Integer> numbers) {
        Validator.validateNumbersInRange(numbers);
        validateNumberLength(numbers);
        validateDuplicatedNumber(numbers);
    }

    private void validateNumberLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.WRONG_NUMBER_LENGTH.getMessage());
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ExceptionMessage.HAS_DUPLICATED_NUMBER.getMessage());
        }
    }

    public static Lotto generateUserLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, LOTTO_SIZE);
        return new Lotto(numbers);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int countMatchingNumber(Lotto that) {
        List<Integer> copyNumbers = new ArrayList<>(numbers);
        copyNumbers.retainAll(that.numbers);
        return copyNumbers.size();
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

}
