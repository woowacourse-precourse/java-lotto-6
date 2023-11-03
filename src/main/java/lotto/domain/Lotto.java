package lotto.domain;

import java.util.List;
import lotto.dto.LottoResponseDtos;
import lotto.dto.LottoResponseDtos.LottoResponseDto;
import lotto.utils.NumberUtils;
import lotto.utils.constant.LottoConstant;
import lotto.utils.message.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = NumberUtils.sorted(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicated(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_SIZE);
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        long count = numbers.stream().distinct().count();
        if (count != LottoConstant.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER);
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.forEach(this::validateRange);
    }

    private void validateRange(int n) {
        if (n < LottoConstant.LOTTO_NUMBER_MIN || n > LottoConstant.LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE);
        }
    }

    public LottoResponseDto toResponseDto() {
        return new LottoResponseDto(numbers);
    }
}
