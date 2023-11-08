package lotto.view;

import lotto.domain.IssuedLotto;
import lotto.domain.Lotto;

public class Output {

    private static final String LOTTO_QUANTITY_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String WINNING_STATISTICS_MESSAGE = "\n당첨 통계\n---";
    private static final String TOTAL_RETURN_MESSAGE = "총 수익률은 %s%%입니다.";


    public void printLottoQuantity(int quantityOfLotto) {
        System.out.printf(LOTTO_QUANTITY_MESSAGE, quantityOfLotto);
    }

    public void printLottoNumbers(IssuedLotto issuedLotto) {
        for (Lotto lotto : issuedLotto.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinningStatistics() {
        System.out.println(WINNING_STATISTICS_MESSAGE);
    }

    public void printWinningDetails(String winningDetails) {
        System.out.println(winningDetails);
    }

    public void printTotalReturn(String totalReturns) {
        System.out.printf(TOTAL_RETURN_MESSAGE, totalReturns);
    }
}
