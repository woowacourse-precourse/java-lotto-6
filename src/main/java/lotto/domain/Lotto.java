package lotto.domain;

import static lotto.constant.ExceptionMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.constant.ExceptionMessage.LOTTO_SIZE_ERROR;
import static lotto.constant.ExceptionMessage.NUMBER_OUT_OF_RANGE;
import static lotto.constant.LottoInfo.LOTTO_SIZE;
import static lotto.constant.LottoInfo.MAXIMUM_NUMBER;
import static lotto.constant.LottoInfo.MINIMUM_NUMBER;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateDuplicateNumber(numbers);
        validateNumberRange(numbers);
        this.numbers = numbers;
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE.getInfo()) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> nonDuplicatedNumbers = numbers.stream().collect(Collectors.toSet());
        if (nonDuplicatedNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        numbers.stream().forEach(number -> {
            if (number < MINIMUM_NUMBER.getInfo() || number > MAXIMUM_NUMBER.getInfo()) {
                throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.getMessage());
            }
        });
    }

    public boolean isContainNumber(int number) {
        if (this.numbers.contains(number)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
