package lotto.domain;

import lotto.system.LottoRankConstant;
import lotto.system.SystemConstant;
import lotto.system.SystemMessage;

public class WinningStat {
    private final LottoRankConstant lottoRankConstant;

    private Integer count;

    private WinningStat(int rank) {
        count = SystemConstant.NOTHING.getValue();
        lottoRankConstant = LottoRankConstant.findByRank(rank);
    }

    public static WinningStat create(int rank) {
        return new WinningStat(rank);
    }

    public void adder() {
        count++;
    }

    public String createMessage() {
        return String.format(SystemMessage.WINNING_STAT_MASSAGE_FORMAT.getMessage()
                , lottoRankConstant.getMessage(), count);
    }

    public boolean isThis(int matchingNumbers, boolean hasBonusNumber) {
        return lottoRankConstant.getMatchingNumbers() == matchingNumbers
                && lottoRankConstant.getHasBonusNumber() == hasBonusNumber;
    }

    public long getProfit() {
        return lottoRankConstant.getPrize() * count;
    }

    public int getRank() {
        return lottoRankConstant.getRank();
    }
}
