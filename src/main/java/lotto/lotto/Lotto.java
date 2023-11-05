package lotto.lotto;

import static lotto.exception.ExceptionMessage.WRONG_LOTTO_NUMBER_SIZE;
import static lotto.lotto.LottoResult.SECOND_PRIZE;
import static lotto.lotto.LottoResult.THIRD_PRIZE;

import java.util.List;
import java.util.stream.Collectors;
import lotto.validator.LottoNumberValidator;

final class Lotto {
    private final List<Integer> numbers;

    Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateEachNumberSize(numbers);
        validateDuplicateNumbers(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateEachNumberSize(List<Integer> numbers) {
        numbers.forEach(number -> {
            LottoNumberValidator.validateNumberIsLottoNumber(number, WRONG_LOTTO_NUMBER_SIZE);
        });
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        LottoNumberValidator.validateDuplicateLottoNumber(numbers);
    }

    LottoResult calcLottoResult(LottoAnswer lottoAnswer) {
        int bingGoCount = (int) numbers.stream().filter(lottoAnswer::containAnswer).count();
        LottoResult lottoResult = LottoResultMapper.fromBingGoCount(bingGoCount);
        if (lottoResult == null) {
            if (lottoAnswer.containBonus(numbers)) {
                return SECOND_PRIZE;
            }
            return THIRD_PRIZE;
        }
        return lottoResult;
    }

    @Override
    public String toString() {
        String collect = numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        return "[%s]".formatted(collect);
    }
}
