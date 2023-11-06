package lotto.dto;

import java.util.List;

public record WinningResult(List<WinningStatus> winningStatuses, double returnRate) {
}
