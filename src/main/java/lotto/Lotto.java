package lotto;

import static lotto.Enum.ErrorMessage.DUPLICATED_ERROR;
import static lotto.Enum.ErrorMessage.LENGTH_ERROR;
import static lotto.Enum.ErrorMessage.NUMBER_NOT_IN_RANGE_ERROR;
import static lotto.Enum.Number.SIX;
import static lotto.Enum.Number.FORTY_FIVE;
import static lotto.Enum.Number.ONE;

import java.util.List;

public class Lotto {
    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumbersLength(numbers);
        validateLottoNumbersNotDuplicated(numbers);
        validateLottoNumbersInRange(numbers);
        this.lottoNumbers = numbers;
    }

    public static void validateLottoNumbersLength(List<Integer> numbers) {
        if (numbers.size() != SIX.getNumber()) {
            throw new IllegalArgumentException(LENGTH_ERROR.getMessage());
        }
    }

    private void validateLottoNumbersInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < ONE.getNumber() || number > FORTY_FIVE.getNumber()) {
                throw new IllegalArgumentException(NUMBER_NOT_IN_RANGE_ERROR.getMessage());
            }
        }
    }

    public static void validateLottoNumbersNotDuplicated(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATED_ERROR.getMessage());
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
