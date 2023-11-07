package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.constant.ErrorDetail;

public class Lotto {
    private final List<Integer> numbers;

    protected static final Integer maxNumber = 45;
    protected static final Integer minNumber = 1;
    private static final Integer sizeOfNumbers = 6;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != sizeOfNumbers) {
            throw new IllegalArgumentException(ErrorDetail.NUMBER_ERROR.getMessage(sizeOfNumbers));
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorDetail.DUPLICATED_ERROR.getMessage());
        }
        if (Collections.max(numbers) > maxNumber || Collections.min(numbers) < minNumber) {
            throw new IllegalArgumentException(ErrorDetail.RANGE_ERROR.getMessage(minNumber, maxNumber));
        }
    }

    public boolean isContain(Integer number) {
        return numbers.contains(number);
    }

    public static Lotto generateLotto() {
        List<Integer> list = new ArrayList<>(Randoms.pickUniqueNumbersInRange(minNumber, maxNumber, sizeOfNumbers));
        Collections.sort(list);

        return new Lotto(list);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
