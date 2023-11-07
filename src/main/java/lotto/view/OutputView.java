package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.domain.Rank;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String BUY_N = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String DIVISION_LINE = "---";
    private static final String LEFT_PARENTHESIS = "(";
    private static final String RIGHT_PARENTHESIS = ")";
    private static final String WON = "원";
    private static final String BLANK = " ";
    private static final String DASH = "-";
    private static final String COUNT = "개";
    private static final String TOTAL_RATE_OF_RETURN = "총 수익률은 ";
    private static final String PERCENT = "%";
    private static final String IT_IS = "입니다.";
    private static final String ERROR_HEADER = "[ERROR] ";

    public void printInputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
    }

    public void printLottoAmountAndLottoNumbers(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + BUY_N);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printInputWinningNumbers() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBERS);
    }

    public void printInputBonusNumber() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public void printWinningStatistics(Map<Rank, Integer> winningStatistics) {
        DecimalFormat thousandFormat = new DecimalFormat("###,###");

        System.out.println();
        System.out.println(WINNING_STATISTICS);
        System.out.println(DIVISION_LINE);
        for (Rank rank : winningStatistics.keySet()) {
            String prizeMoney = thousandFormat.format(rank.getPrizeMoney());
            int matchNumbers = winningStatistics.get(rank);
            System.out.println(rank.getExplanation() + BLANK
                    + LEFT_PARENTHESIS + prizeMoney + WON + RIGHT_PARENTHESIS
                    + BLANK + DASH + BLANK + matchNumbers + COUNT);
        }
    }

    public void printRateOfReturn(double rateOfReturn) {
        DecimalFormat decimalFormat = new DecimalFormat("###,##0.0");
        String formattedRateOfReturn = decimalFormat.format(rateOfReturn);

        System.out.println(TOTAL_RATE_OF_RETURN +
                formattedRateOfReturn + PERCENT + IT_IS);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_HEADER + errorMessage);
    }

}
