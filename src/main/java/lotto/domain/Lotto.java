package lotto.domain;

import lotto.LottoUtil;
import lotto.constant.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.LottoConstant.LOTTO_NUMBER_MAX;
import static lotto.constant.LottoConstant.LOTTO_NUMBER_MIN;

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
        if (!isLottoNumbers(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE_LOTTO_NUMBER);
        }
        if (LottoUtil.hasDuplicatedNumbers(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_LOTTO_NUMBER);
        }
    }

    // TODO: 추가 기능 구현
    private boolean isLottoNumbers(List<Integer> numbers) {
        return numbers.stream().allMatch(this::isLottoNumber);
    }

    private boolean isLottoNumber(int number) {
        return LottoUtil.isInRange(number, LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    @Override
    public String toString() {
        List<Integer> sortedNumbers = numbers.stream().sorted().toList();
        return "[" +
                sortedNumbers.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ")) +
                "]";
    }
}
