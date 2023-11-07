package lotto.domain;

import static lotto.constants.ErrorCode.DUPLICATED_LOTTO_NUMBER;
import static lotto.constants.ErrorCode.INVALID_LOTTO_SIZE;
import static lotto.constants.LottoRule.LOTTO_MAX_SIZE;
import static lotto.constants.Message.SEPARATOR_REGEX;
import static lotto.constants.Message.TICKET_PREFIX;
import static lotto.constants.Message.TICKET_SEPARATOR;
import static lotto.constants.Message.TICKET_SUFFIX;

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

    public Lotto(String number) {
        List<Integer> numbers = splitToList(number);
        validate(numbers);
        this.numbers = sortByAscent(numbers);
    }

    private List<Integer> splitToList(String number) {
        try {
            return Arrays.stream(number.split(SEPARATOR_REGEX.getMessage()))
                    .map(Integer::parseInt)
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

        return convertToLotto(sortedNumbers);
    }

    private List<LottoNumber> convertToLotto(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> LottoNumber.from(String.valueOf(number)))
                .toList();
    }

    public boolean hasCertainNumber(LottoNumber target) {
        return this.numbers.contains(target);
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }


    //TODO: toString으로 문자열을 직접 만들어서 보내는 것은 적절하지 않은 것 같다! 데이터만 넘기는 방법을 사용하자
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(TICKET_PREFIX.getMessage());
        for (int i = 0; i < numbers.size() - 1; ++i) {
            builder.append(numbers.get(i).getNumber());
            builder.append(TICKET_SEPARATOR.getMessage());
        }
        builder.append(numbers.get(numbers.size() - 1).getNumber());
        builder.append(TICKET_SUFFIX.getMessage());

        return builder.toString();
    }
}
