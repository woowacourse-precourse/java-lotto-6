package lotto.dto.input;

import java.util.List;
import lotto.dto.input.builder.WinningCombinationBuilder;

public record WinningCombinationDto(List<Integer> winningNumbers, int bonusNumber) {
    public static WinningCombinationDto builder() {
        return WinningCombinationBuilder.builder().build();
    }
}
