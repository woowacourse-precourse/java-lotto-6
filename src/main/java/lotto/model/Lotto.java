package lotto.model;

import java.util.Collections;

import java.util.List;

import static lotto.constant.MessageConstants.*;

import lotto.validator.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NUMBER_SIZE_ERROR_MESSAGE);
        }
        LottoValidator lottoValidator = new LottoValidator();
        lottoValidator.validate_all(numbers);
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    public int countMatch(Lotto winningLotto) {
        int matchCount = 0;
        for (int number : numbers) {
            if (winningLotto.containNumber(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean containNumber(int number) {
        return numbers.contains(number);
    }


}