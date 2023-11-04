package lotto.model.domain;

import java.util.List;
import lotto.constance.GameConst;
import lotto.constance.PrintConst;
import lotto.util.LottoGameException;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateNumbersNotDuplicated(numbers);
        validateNumbersRange(numbers);
    }

    private void validateNumbersRange(List<Integer> numbers) {
        long wrongNumberCount = numbers.stream()
                .filter(number -> number > GameConst.LOTTO_RANGE_END ||
                        number < GameConst.LOTTO_RANGE_START)
                .count();
        if(wrongNumberCount != 0){
            throw LottoGameException.WRONG_LOTTO_RANGE.makeException();
        }
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw LottoGameException.WRONG_LOTTO_SIZE.makeException();
        }
    }

    private void validateNumbersNotDuplicated(List<Integer> numbers) {
        int distinctNum = (int) numbers.stream()
                .distinct()
                .count();
        if (distinctNum != LOTTO_SIZE){
            throw LottoGameException.DUPLICATED_LOTTO_NUMBER.makeException();
        }
    }

    // TODO: 추가 기능 구현

    @Override
    public String toString() {
        return String.format(PrintConst.FORMAT_LOTTO_NUMBERS, this.numbers.toArray());
    }
}
