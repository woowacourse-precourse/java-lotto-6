package lotto.view;

import static lotto.config.WiningRank.RANK1;
import static lotto.config.WiningRank.RANK2;
import static lotto.config.WiningRank.RANK3;
import static lotto.config.WiningRank.RANK4;
import static lotto.config.WiningRank.RANK5;
import static lotto.string.OutputMessage.NEWLINE_MESSAGE;

import java.util.List;
import lotto.config.WiningRank;
import lotto.domain.Lotto;
import lotto.domain.RankBoard;
import lotto.string.OutputMessage;

public class Output {
    public void requestAmount() {
        System.out.println(OutputMessage.REQUEST_AMOUNT_MESSAGE.getMessage());
    }

    public void printPurchaseCount(int purchaseCount) {
        System.out.print(NEWLINE_MESSAGE.getMessage());
        System.out.print(purchaseCount);
        System.out.println(OutputMessage.PURCHASE_COUNT_MESSAGE.getMessage());
    }

    public void printLottos(List<Lotto> lottos) {
        for(Lotto lotto:lottos) {
            System.out.println(lotto.getLotto());
        }
    }

    public void requestWiningNumber() {
        System.out.print(NEWLINE_MESSAGE.getMessage());
        System.out.println(OutputMessage.REQUEST_WININGNUMBER_MESSAGE.getMessage());
    }

    public void requestBonusNumber() {
        System.out.print(NEWLINE_MESSAGE.getMessage());
        System.out.println(OutputMessage.REQUEST_BONUSNUMBER_MESSAGE.getMessage());
    }

    public void printWiningStatisticsStart() {
        System.out.print(NEWLINE_MESSAGE.getMessage());
        System.out.println(OutputMessage.WININGSTATISTIC_START_MESSAGE.getMessage());
        System.out.println(OutputMessage.DIVISIONLINE_MESSAGE.getMessage());
    }

    public void printWiningCount(WiningRank rank, RankBoard board) {
        if(rank == RANK1) {
            System.out.print(OutputMessage.RANK1_COUNT_MESSAGE.getMessage());
            System.out.print(board.getRankCount(rank));
            System.out.println(OutputMessage.RANK_COUNT_UNIT_MESSAGE.getMessage());
        }
        if(rank == RANK2) {
            System.out.print(OutputMessage.RANK2_COUNT_MESSAGE.getMessage());
            System.out.print(board.getRankCount(rank));
            System.out.println(OutputMessage.RANK_COUNT_UNIT_MESSAGE.getMessage());
        }
        if(rank == RANK3) {
            System.out.print(OutputMessage.RANK3_COUNT_MESSAGE.getMessage());
            System.out.print(board.getRankCount(rank));
            System.out.println(OutputMessage.RANK_COUNT_UNIT_MESSAGE.getMessage());
        }
        if(rank == RANK4) {
            System.out.print(OutputMessage.RANK4_COUNT_MESSAGE.getMessage());
            System.out.print(board.getRankCount(rank));
            System.out.println(OutputMessage.RANK_COUNT_UNIT_MESSAGE.getMessage());
        }
        if(rank == RANK5) {
            System.out.print(OutputMessage.RANK5_COUNT_MESSAGE.getMessage());
            System.out.print(board.getRankCount(rank));
            System.out.println(OutputMessage.RANK_COUNT_UNIT_MESSAGE.getMessage());
        }
    }

    public void printReturnRate(double returnRate) {
        System.out.print(OutputMessage.STATISTIC_RESULT_FRONT_MESSAGE.getMessage());
        String returnRateString = String.format("%1f", returnRate);
        System.out.print(returnRateString);
        System.out.println(OutputMessage.STATISTIC_RESULT_LAST_MESSAGE.getMessage());

    }
}
