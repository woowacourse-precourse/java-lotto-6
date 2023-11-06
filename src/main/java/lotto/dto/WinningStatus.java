package lotto.dto;

import lotto.domain.WinningType;

public record WinningStatus(WinningType winningType, int count) {
}
