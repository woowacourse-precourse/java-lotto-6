package lotto.statistics.calculatewinning;

import lotto.Lotto;

public record ComparativeRecord(Lotto lotto, WinningResults<NotWin, Win> results) {
}
