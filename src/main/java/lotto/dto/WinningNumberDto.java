package lotto.dto;

import java.util.List;

public record WinningNumberDto(List<Integer> winningNumbers, int bonusNumber) {
}
