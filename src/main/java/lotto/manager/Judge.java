package lotto.manager;

import static lotto.utils.constant.LottoWinningConstant.NONE;

import java.util.HashMap;
import java.util.Map;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.WinningLotto;
import lotto.utils.constant.LottoWinningConstant;

public class Judge {

    private final static int LOTTO_WINNING_DEFAULT_VALUE = 0;

    private final WinningLotto winningLotto;
    private Map<LottoWinningConstant, Integer> statistics;

    private Judge(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
        statistics = new HashMap<>();
        for (LottoWinningConstant lottoWinningConstant : LottoWinningConstant.values()) {
            statistics.put(lottoWinningConstant, LOTTO_WINNING_DEFAULT_VALUE);
        }
    }

    public static Judge of(WinningLotto winningLotto) {
        return new Judge(winningLotto);
    }

    public void judge(Lotto lotto) {
        int matchCount = winningLotto.numberMatches(lotto.getNumbers());
        System.out.println(matchCount);
        boolean isBonusMatch = winningLotto.isBonusMatches(lotto.getNumbers());

        for (LottoWinningConstant lottoWinningConstant : LottoWinningConstant.values()) {
            if (matchCount == lottoWinningConstant.getWinningCount()
                    && isBonusMatch == lottoWinningConstant.isBonusNeeded()) {
                statistics.put(lottoWinningConstant, statistics.get(lottoWinningConstant) + 1);
            }
        }
        statistics.put(NONE, statistics.get(NONE) + 1);
    }

    public Map<LottoWinningConstant, Integer> getStatistics() {
        return statistics;
    }
}
