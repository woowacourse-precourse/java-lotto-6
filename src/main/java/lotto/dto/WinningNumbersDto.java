package lotto.dto;

import java.util.List;

public record WinningNumbersDto(List<Integer> winningNumbers, int bonusNumber) {
}