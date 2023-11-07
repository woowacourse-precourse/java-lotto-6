package lotto;

import lotto.constants.LottoConstants;
import lotto.dto.LottoDto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.exception.LottoErrorCode.*;

public class Lotto {
    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }


    public LottoDto toDto() {
        return new LottoDto(List.copyOf(numbers));
    }


    private void validate(List<Integer> numbers) {
        validateLottoLength(numbers);
        validateLottoDuplication(numbers);
        validateInbound(numbers);
    }

    private void validateLottoLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_LENGTH.getMessage());
        }
    }

    private void validateLottoDuplication(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER.getMessage());
        }
    }

    private void validateInbound(List<Integer> numbers) {
        boolean isAllValidLottoNumber = numbers.stream()
                .allMatch(this::isLottoNumber);

        if (!isAllValidLottoNumber) {
            throw new IllegalArgumentException(OUT_OF_RANGE.getMessage());
        }
    }

    private boolean isLottoNumber(Integer number) {
        return LottoConstants.LOTTO_MIN <= number && number <= LottoConstants.LOTTO_MAX;
    }

    public boolean contains(int number) {
        return this.numbers.contains(number);
    }

    public int matchCount(Lotto o) {
        return (int) this.numbers.stream()
                .filter(o.numbers::contains)
                .distinct()
                .count();
    }

}
