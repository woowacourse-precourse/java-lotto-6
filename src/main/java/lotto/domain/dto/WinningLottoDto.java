package lotto.domain.dto;

import java.util.List;
import lotto.validator.WinningLottoValidator;

public record WinningLottoDto(List<Integer> numbers) {
    public WinningLottoDto {
        WinningLottoValidator.validateWinningNumbers(numbers);
    }
}