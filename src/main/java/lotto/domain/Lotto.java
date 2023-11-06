package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.message.ExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> orderedNumbers = new ArrayList<>(numbers);
        orderedNumbers.sort(Integer::compareTo);
        validate(orderedNumbers);
        this.numbers = orderedNumbers;
    }

    public static Lotto createRandomLotto(Money wallet) {
        wallet.payLotto();
        List<Integer> pickedNumbers = Randoms.pickUniqueNumbersInRange(
                LottoOption.LOTTO_START_INCLUSIVE,
                LottoOption.LOTTO_END_INCLUSIVE,
                LottoOption.LOTTO_SIZE);
        return new Lotto(pickedNumbers);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicates(numbers);
        validateInRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoOption.LOTTO_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_SIZE);
        }
    }

    private void validateDuplicates(List<Integer> numbers) {
        int distinctSize = (int) numbers.stream()
                .distinct()
                .count();
        if (distinctSize != numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_LOTTO_NUMBER);
        }
    }

    private void validateInRange(List<Integer> numbers) {
        numbers.stream()
                .filter(this::isOutRangeLottoNumber)
                .findAny()
                .ifPresent((i) -> {
                    throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE_LOTTO_NUMBER);
                });
    }

    private boolean isOutRangeLottoNumber(Integer number) {
        return number < LottoOption.LOTTO_START_INCLUSIVE ||
                number > LottoOption.LOTTO_END_INCLUSIVE;
    }

    public boolean hasNumber(int number) {
        return numbers.contains(number);
    }

    public int getMatchCount(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::hasNumber)
                .count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        String listString = numbers
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        return "[" + listString + "]";
    }
}
