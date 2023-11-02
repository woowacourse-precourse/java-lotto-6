package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoStatistics {
    private static final Map<WinningRank, Integer> winningResult = new EnumMap<>(WinningRank.class);

    private final LottoWinningMachine lottoWinningMachine;
    private final User user;

    private LottoStatistics(final LottoWinningMachine lottoWinningMachine, final User user) {
        this.lottoWinningMachine = lottoWinningMachine;
        this.user = user;
    }

    public static LottoStatistics checkLottoResult(final LottoWinningMachine lottoWinningMachine, final User user) {
        final LottoStatistics lottoStatistics = new LottoStatistics(lottoWinningMachine, user);
        initWinningResult();
        return lottoStatistics;
    }

    private static void initWinningResult() {
        for (final WinningRank winningRank : WinningRank.values()) {
            winningResult.put(winningRank, 0); // 모든 Rank에 대한 당첨 횟수 초기화
        }
    }
}
