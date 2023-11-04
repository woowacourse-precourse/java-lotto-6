package lotto.dto.input;

import java.util.Arrays;
import java.util.List;
import lotto.dto.LottoNumberDto;

public record WinningNumbersDto(List<LottoNumberDto> winningNumbers) {
    public static WinningNumbersDto from(String input) {
        List<LottoNumberDto> winningNumbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .map(LottoNumberDto::new)
                .toList();
        return new WinningNumbersDto(winningNumbers);
    }
}
