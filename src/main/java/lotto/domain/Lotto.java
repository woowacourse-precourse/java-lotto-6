package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.dto.LottoDto;
import lotto.utils.ValidationUtil;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        ValidationUtil.validateCorrectNumbersCount(numbers);
        ValidationUtil.validateNoDuplicates(numbers);
        ValidationUtil.validateNumberRange(numbers);
    }

    // TODO: 추가 기능 구현
    private List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    public LottoDto toDTO() {
        return new LottoDto(numbers);
    }
}
