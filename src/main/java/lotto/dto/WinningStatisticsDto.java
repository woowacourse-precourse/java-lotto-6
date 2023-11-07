package lotto.dto;

import lotto.service.WinningPolicy;

public record WinningStatisticsDto(WinningPolicy winningPolicy, int matchCount) {
}
