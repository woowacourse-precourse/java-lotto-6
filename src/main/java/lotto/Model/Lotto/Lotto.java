package lotto.Model.Lotto;

import java.util.List;

import static lotto.Common.LottoValue.*;

import java.util.stream.IntStream;
import lotto.Common.LottoValue;

import static lotto.Common.ErrorMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    /**
     * 랜덤수 를 통해 6자리 또로 1장 을 같고 있느 객체,
     *
     * @param numbers
     */

    public Lotto(List<Integer> numbers) {
        validateNumberDuplicate(numbers);
        validateNumberCount(numbers);
        validateNumberRange(numbers);
        validateNumberSorting(numbers);
        this.numbers = numbers;
    }


    //생성된 로또 번호가 6개가 아닐경우
    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT_NUMBER.getValue()) {
            throw new IllegalArgumentException(NUMBER_COUNT_INVALID.getMessage());
        }
    }

    //수가 1~45 사인인지
    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LOTTO_FIRST_NUMBER.getValue() || number > LOTTO_FINAL_NUMBER.getValue()) {
                throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.getMessage());
            }
        }

    }

    //각 수에 중복이 없는지
    private void validateNumberDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().toList().size()
                != LOTTO_COUNT_NUMBER.getValue()) {
            throw new IllegalArgumentException(NUMBER_DUPLICATE.getMessage());
        }

    }

    //각 수가 오름차순 으로 정렬 되어 있는지
    private void validateNumberSorting(List<Integer> numbers) {
        if ( !IntStream.range(1, numbers.size())
                .allMatch(i -> numbers.get(i) > numbers.get(i - 1))) {
            throw new IllegalArgumentException(NUMBER_NOT_SORTED.getMessage());
        }
    }


    public List<Integer> getNumbers() {
        return this.numbers;
    }



}
