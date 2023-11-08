package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.message.ExceptionMessage;

public record Lotto(List<Integer> numbers) {
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> orderedNumbers = new ArrayList<>(numbers);
        orderedNumbers.sort(Integer::compareTo);
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
        validateNull(numbers);
        validateSize(numbers);
        validateDuplicates(numbers);
        validateInRange(numbers);
    }

    private void validateNull(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NULL);
        }
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
        if (isNotEquals(numbers, distinctSize)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_LOTTO_NUMBER);
        }
    }

    private boolean isNotEquals(List<Integer> numbers, int distinctSize) {
        return distinctSize != numbers.size();
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
}
