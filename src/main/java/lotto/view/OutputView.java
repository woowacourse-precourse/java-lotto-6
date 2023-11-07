package lotto.view;

import static lotto.message.LotteryMessages.WINNING_STATISTICS;
import static lotto.message.MessageFormat.FIVE_MATCH;
import static lotto.message.MessageFormat.FIVE_MATCH_WITH_BONUS;
import static lotto.message.MessageFormat.FOUR_MATCH;
import static lotto.message.MessageFormat.NUMBER_OF_TICKETS_PURCHASED;
import static lotto.message.MessageFormat.SIX_MATCH;
import static lotto.message.MessageFormat.THREE_MATCH;
import static lotto.message.MessageFormat.TOTAL_YIELDS;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningList;

public class OutputView {
    public void printBuyLottoCount(int buyLottoCount) {
        System.out.printf(NUMBER_OF_TICKETS_PURCHASED.getFormat(), buyLottoCount);
    }
    public void printLottoNumbers(Lottos lottos) {
        for(int i = 0; i < lottos.getLottosSize(); i++) {
            Lotto lotto = lottos.getLotto(i);
            StringBuilder lottoNumbers = lotto.getLottoNumbersString("[", "]", ", ");
            System.out.println(lottoNumbers);
        }
    }
    public void printWinningResult(WinningList winningList) {
        System.out.println(WINNING_STATISTICS.getMessage());
        System.out.printf(THREE_MATCH.getFormat(), winningList.getWinningCount(3));
        System.out.printf(FOUR_MATCH.getFormat(), winningList.getWinningCount(4));
        System.out.printf(FIVE_MATCH.getFormat(), winningList.getWinningCount(5));
        System.out.printf(FIVE_MATCH_WITH_BONUS.getFormat(), winningList.getWinningCount(9));
        System.out.printf(SIX_MATCH.getFormat(), winningList.getWinningCount(6));
    }

    public void printYields(Double yields) {
        System.out.printf(TOTAL_YIELDS.getFormat(), yields);
    }
}
