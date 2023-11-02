package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoStatistics {
    private final LottoWinningMachine lottoWinningMachine;
    private final User user;
    private final Map<WinningRank, Integer> winningResult = new EnumMap<>(WinningRank.class);

    public LottoStatistics(final LottoWinningMachine lottoWinningMachine, final User user) {
        this.lottoWinningMachine = lottoWinningMachine;
        this.user = user;
    }
}
