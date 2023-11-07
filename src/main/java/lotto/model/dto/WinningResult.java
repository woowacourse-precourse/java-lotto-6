package lotto.model.dto;

import lotto.model.WinningRule;

public record WinningResult(WinningRule winningRule, int winningCount) {
}
