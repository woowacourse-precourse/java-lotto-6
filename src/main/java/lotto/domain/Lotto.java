package lotto.domain;

import static lotto.constants.ErrorCode.DUPLICATED_LOTTO_NUMBER;
import static lotto.constants.ErrorCode.INVALID_LOTTO_SIZE;
import static lotto.constants.LottoRule.LOTTO_MAX_SIZE;
import static lotto.constants.Message.SEPARATOR_REGEX;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import lotto.constants.ErrorCode;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortByAscent(numbers);
    }

    // TODO: 하나의 생성자로 처리할 수 있는 방법은 없을까?
    public Lotto(String number) {
        List<Integer> numbers = splitToList(number);
        validate(numbers);
        this.numbers = sortByAscent(numbers);
    }

    private List<Integer> splitToList(String number) {
        try {
            return Arrays.stream(number.split(SEPARATOR_REGEX.getMessage()))
                    .map((num -> Integer.parseInt(num.trim())))
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.NOT_INTEGER.getMessage());
        }
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

        return convertToLottoNumber(sortedNumbers);
    }

    private List<LottoNumber> convertToLottoNumber(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> LottoNumber.from(String.valueOf(number)))
                .toList();
    }

    public boolean hasCertainNumber(LottoNumber target) {
        return this.numbers.contains(target);
    }

    public int countDuplicatedNumber(Lotto target) {
        return Math.toIntExact(this.numbers
                .stream()
                .filter(target::hasCertainNumber)
                .count());
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public List<String> getNumbersAsString() {
        return numbers.stream()
                .map(lottoNumber -> String.valueOf(lottoNumber.getNumber()))
                .toList();
    }
}
