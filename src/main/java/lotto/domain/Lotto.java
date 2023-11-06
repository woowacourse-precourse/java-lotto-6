package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.ErrorMessage;
import lotto.util.LottoGenerator;
import lotto.controller.dto.LottoResponseDto;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public LottoResponseDto toResponseDto() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return new LottoResponseDto(sortedNumbers);
    }

    public int countContainsNumber(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::isContain)
                .count();
    }

    public boolean isContain(int lottoNumber) {
        return numbers.contains(lottoNumber);
    }


    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumbersDuplicated(numbers);
        validateNumbersInRange(numbers);
    }

    private static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE_IS_OVER);
        }
    }

    private void validateNumbersDuplicated(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_IS_DUPLICATED);
        }
    }

    private void validateNumbersInRange(List<Integer> numbers) {
        for (Integer num : numbers) {
            if (num < LottoGenerator.LOTTO_START_INCLUSIVE
                    || num > LottoGenerator.LOTTO_END_INCLUSIVE) {
                throw new IllegalArgumentException(ErrorMessage.NUMBER_IS_OVER_RANGE);
            }
        }
    }
}
