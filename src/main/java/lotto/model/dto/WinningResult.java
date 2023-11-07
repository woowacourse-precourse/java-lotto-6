package lotto.model.dto;

import lotto.model.WinningRule;

public record WinningResult(WinningRule winningRule, int winningCount) {
    private static final String COUNT_PREFIX = " - ";
    private static final String COUNT_SUFFIX = "개\n";

    public String format() {
        return winningRule.getDescription() + COUNT_PREFIX + winningCount + COUNT_SUFFIX;
    }
}
