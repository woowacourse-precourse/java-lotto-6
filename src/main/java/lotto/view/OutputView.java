package lotto.view;

import java.math.BigDecimal;
import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    public static final String LOTTO_PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS_TITLE = "당첨 통계";
    private static final String SEPARATOR = "---";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %s%%입니다.";


    public void displayLottoCount(long lottoCount) {
        System.out.println(lottoCount + LOTTO_PURCHASE_MESSAGE);
    }

    public void displayLottoTickets(List<Lotto> tickets) {
        for (Lotto lotto : tickets) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void displayWinningLotto(String winnerStatistics) {
        System.out.println(WINNING_STATISTICS_TITLE);
        System.out.println(SEPARATOR);
        System.out.print(winnerStatistics);
    }

    public void displayRateOfReturn(BigDecimal yield) {
        System.out.printf(RATE_OF_RETURN_MESSAGE, yield);
    }

    public void displayErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printEmptyLine() {
        System.out.println();
    }
}
