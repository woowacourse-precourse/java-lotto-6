package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.config.GameConfig.LOTTO_NUMBERS_LENGTH;
import static lotto.exception.ErrorMessage.LOTTO_NUMBERS_DUPLICATED;
import static lotto.exception.ErrorMessage.LOTTO_NUMBERS_INPUT_LENGTH_INVALID;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumber(numbers);
        this.lottoNumbers = new ArrayList<>(convertToLottoNumbers(numbers));
    }

    public static Lotto create(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private static void validateLottoNumber(List<Integer> numbers) {
            validateLottoNumbersLength(numbers);
            validateIsNumberDuplicate(numbers);
    }

    private static void validateLottoNumbersLength(List<Integer> numbers) {
        if (isLengthInvalid(numbers)) {
            throw new IllegalArgumentException(String.format(
                    LOTTO_NUMBERS_INPUT_LENGTH_INVALID.getMessage(),
                    LOTTO_NUMBERS_LENGTH.getNumber())
            );
        }
    }

    private static boolean isLengthInvalid(List<Integer> numbers) {
        return numbers.size() != LOTTO_NUMBERS_LENGTH.getNumber();
    }

    private static void validateIsNumberDuplicate(List<Integer> numbers) {
        if (isNumberDuplicated(numbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_DUPLICATED.getMessage());
        }
    }

    private static boolean isNumberDuplicated(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != numbers.size();
    }

    private static List<LottoNumber> convertToLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::create)
                .toList();
    }

    public List<Integer> getIntegerNumbers() {
        return lottoNumbers.stream()
                .map(LottoNumber::getLottoNumber)
                .toList();
    }

    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(lottoNumbers);
    }
}
