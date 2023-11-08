package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.constants.LottoConstants;
import lotto.exception.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!validateDuplication(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATION_NUMBER.getErrorMessage());
        }
        if (!validateLottoNumbersCount(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_LOTTO_COUNTS.getErrorMessage());
        }
        if(!validateNumberArrange(numbers)){
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_ARRANGE.getErrorMessage());
        }
    }

    public int getMatchLottoCount(WinningLotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto::isContain)
                .count();
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    private boolean validateLottoNumbersCount(List<Integer> numbers) {
        return numbers.size() == LottoConstants.COUNT.getNumber();
    }

    private boolean validateDuplication(List<Integer> numbers) {
        return numbers.stream().distinct().count() == numbers.size();
    }

    private boolean validateNumberArrange(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(this::isNumberArrange);
    }

    private boolean isNumberArrange(int number) {
        return number >= LottoConstants.RANDOM_MIN_NUMBER.getNumber()
                && number <= LottoConstants.RANDOM_MAX_NUMBER.getNumber();
    }

    @Override
    public String toString() {
        return numbers.stream()
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining(LottoConstants.NUMBER_SEPARATOR.getMessage(),
                        LottoConstants.START_SYMBOL.getMessage(),
                        LottoConstants.END_SYMBOL.getMessage()));
    }

}
