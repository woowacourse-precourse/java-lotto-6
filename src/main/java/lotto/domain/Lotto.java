package lotto.domain;

import static lotto.domain.LottoDetails.lottoSize;
import static lotto.domain.LottoDetails.lottoNumberMinimum;
import static lotto.domain.LottoDetails.lottoNumberMaximum;
import static lotto.view.ErrorMessage.printBonusNumberDistinctError;
import static lotto.view.ErrorMessage.printLottoDistinctNumberError;
import static lotto.view.ErrorMessage.printLottoNumberRangeError;
import static lotto.view.ErrorMessage.printLottoNumbersSizeError;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDistinctNumbers(numbers);
        validateNumbersRange(numbers);
    }

    public void validateBonusNumber(BonusNumber bonusNumber) {
        if(numbers.contains(bonusNumber.getValue())) {
            printBonusNumberDistinctError();
            throw new IllegalArgumentException();
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != lottoSize()) {
            printLottoNumbersSizeError();
            throw new IllegalArgumentException();
        }
    }

    private void validateDistinctNumbers(List<Integer> numbers) {
        if(numbers.size() != numbers.stream()
                .distinct()
                .count()) {
            printLottoDistinctNumberError();
            throw new IllegalArgumentException();
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        if(numbers.stream()
                .anyMatch(number -> number < lottoNumberMinimum() || number > lottoNumberMaximum())) {
            printLottoNumberRangeError();
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
