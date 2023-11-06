package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkSize(numbers);
        checkNumberRange(numbers);
        checkDuplicate(numbers);
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            isLottoNumber(number);
        }
    }

    private void isLottoNumber(int number) {
        if (number >= 1 && number <= 45) {
            return;
        }
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        List<Integer> nonDuplicate = numbers.stream().distinct().toList();

        if (nonDuplicate != numbers) {
            throw new IllegalArgumentException();
        }
    }

    public LottoDto createDto() {
        LottoDto lottoDto = new LottoDto(numbers);
        return lottoDto;
    }
}
