package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.constant.LottoRank;
import lotto.constant.LottoRankExpression;

public class OutputView {
    private static final String READ_COST_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String BUYING_AMOUNT_MESSAGE = "%n%d개를 구매했습니다.%n";
    private static final String READ_WINNING_LOTTO_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String READ_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String PREFIX_MESSAGE = "\n당첨 통계\n---";
    private static final String RATE_OF_RETURN_EXPRESSION = "총 수익률은 %.1f%%입니다.";

    public void printReadCostAmountMessage() {
        System.out.println(READ_COST_AMOUNT_MESSAGE);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printLottoNumbers(List<Integer> numbers) { System.out.println(numbers); }

    public void printBuyingAmountMessage(int amount) {
        System.out.printf(BUYING_AMOUNT_MESSAGE, amount);
    }

    public void printReadWinningLottoMessage() {
        System.out.println(READ_WINNING_LOTTO_MESSAGE);
    }

    public void printReadBonusNumberMessage() {
        System.out.println(READ_BONUS_NUMBER_MESSAGE);
    }

    public void printStatisticsPreMessage() { System.out.println(PREFIX_MESSAGE); }

    public void printStatisticsExpression(Map<LottoRank, Integer> rankCounts) {
        for (LottoRankExpression lottoRankExpression : LottoRankExpression.getOrderedExpressions()) {
            int count = rankCounts.get(lottoRankExpression.getLottoRank());
            System.out.println(lottoRankExpression.getExpressionByCount(count));
        }
    }

    public void printRateOfReturnExpression(double rateOfReturn) { System.out.printf(RATE_OF_RETURN_EXPRESSION, rateOfReturn); }
}
