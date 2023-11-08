package lotto.dto.input;

import java.util.List;

public record WinningCombinationDto(List<Integer> winningNumbers, int bonusNumber) {
}
