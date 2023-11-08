package lotto.util;

import static lotto.config.LottoConfig.LOTTO_PRICE;
import static lotto.config.WiningRank.RANK1;
import static lotto.config.WiningRank.RANK2;
import static lotto.config.WiningRank.RANK3;
import static lotto.config.WiningRank.RANK4;
import static lotto.config.WiningRank.RANK5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.config.WiningRank;
import lotto.domain.RankBoard;

public class Statistics {
    public double calculateRateOfReturn(int buyCount, RankBoard board) {
        int earnMoneyResult = 0;
        int spanMoneyResult = LOTTO_PRICE.getNum() * buyCount;

        List<WiningRank> rankSequence = new ArrayList<>(Arrays.asList(RANK1, RANK2, RANK3, RANK4, RANK5));
        for (WiningRank rank : rankSequence) {
            earnMoneyResult = earnMoneyResult + (rank.getPrice() * board.getRankCount(rank));
        }

        double temp = ((double) earnMoneyResult / spanMoneyResult) * 100;

        return Math.round(temp * 10) / 10.0;
    }
}
