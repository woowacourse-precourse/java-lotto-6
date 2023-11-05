package lotto.domain;

import static lotto.constants.ErrorCode.DUPLICATED_LOTTO_NUMBER;
import static lotto.constants.ErrorCode.INVALID_LOTTO_SIZE;
import static lotto.constants.LottoRule.LOTTO_MAX_SIZE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortByAscent(numbers);
    }

    public Lotto(String number) {
        List<Integer> numbers = Arrays.stream(number.split(","))
                .map(Integer::parseInt)
                .toList();
        validate(numbers);
        this.numbers = sortByAscent(numbers);
    }


    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicated(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_MAX_SIZE.getValue()) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE.getMessage());
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        int count = Math.toIntExact(numbers.stream()
                .distinct()
                .count());
        if (count != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER.getMessage());
        }
    }

    private List<LottoNumber> sortByAscent(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        sortedNumbers.sort(Comparator.naturalOrder());

        return convertToDTO(sortedNumbers);
    }

    private List<LottoNumber> convertToDTO(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> LottoNumber.from(String.valueOf(number)))
                .toList();
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }


    //TODO: 매직 넘버 상수로 빼고, builder 관련 로직 개선하기
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < numbers.size() - 1; ++i) {
            builder.append(numbers.get(i).getNumber());
            builder.append(", ");
        }
        builder.append(numbers.get(numbers.size() - 1).getNumber());
        builder.append("]");

        return builder.toString();
    }
}
