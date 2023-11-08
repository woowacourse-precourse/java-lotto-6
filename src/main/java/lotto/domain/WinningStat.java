package lotto.domain;

import lotto.system.LottoRankConstant;
import lotto.system.SystemConstant;
import lotto.system.SystemMessage;

public class WinningStat {
    private final LottoRankConstant lottoRankConstant;

    private Integer count;

    private WinningStat(LottoRankConstant lottoRankConstant, Integer count) {
        this.lottoRankConstant = lottoRankConstant;
        this.count = count;
    }

    public static WinningStat create(int rank) {
        return new WinningStat(LottoRankConstant.findByRank(rank), SystemConstant.NOTHING.getValue());
    }

    public void adder() {
        count++;
    }

    public String createMessage() {
        return String.format(SystemMessage.WINNING_STAT_MASSAGE_FORMAT.getMessage(),
                lottoRankConstant.getMessage(), count);
    }

    public boolean isThis(MatchResult matchResult) {
        return matchResult.isEqaulMatchNumbersCount(lottoRankConstant.getMatchingNumbers())
                && matchResult.isEqaulHasBonusNumber(lottoRankConstant.getHasBonusNumber());
    }

    public long getProfit() {
        return lottoRankConstant.getPrize() * count;
    }

    public int getRank() {
        return lottoRankConstant.getRank();
    }
}
