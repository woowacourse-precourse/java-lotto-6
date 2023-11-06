package lotto.model;

import static lotto.constant.ErrorMessage.DUPLICATED_LOTTO_NUMBER;
import static lotto.constant.LottoNumber.LOTTO_NUMBER_COUNT;
import static lotto.constant.LottoNumber.RANGE_END_NUMBER;
import static lotto.constant.LottoNumber.RANGE_START_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        validateUniqueNumbers(numbers);
    }

    public static Lotto create() {
        return new Lotto(pickNumbers());
    }

    private static void validateUniqueNumbers(List<Integer> pickedNumbers) {
        if (hasDuplicatedNumber(pickedNumbers)) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER.getMessage());
        }
    }

    private static boolean hasDuplicatedNumber(List<Integer> pickedNumbers) {
        return pickedNumbers.stream()
                .distinct()
                .toList()
                .size() != pickedNumbers.size();
    }

    private static List<Integer> pickNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                        RANGE_START_NUMBER.getNumber(),
                        RANGE_END_NUMBER.getNumber(),
                        LOTTO_NUMBER_COUNT.getNumber()
                ).stream()
                .sorted()
                .toList();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
