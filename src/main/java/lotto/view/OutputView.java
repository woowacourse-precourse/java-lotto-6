package lotto.view;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map.Entry;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Rank;
import lotto.domain.dto.Result;

public class OutputView {
    public static final String PURCHASED = "\n%d개를 구매했습니다.\n";
    public static final String WINNING_RESULT = "\n당첨 통계\n---\n";
    public static final String MATCH_COUNT = "개 일치";
    public static final String HAS_BONUS = ", 보너스 볼 일치";
    public static final String PRIZE_COUNT = " (%s원) - %d개\n";
    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,###");
    public static final String RATE_OF_RETURN = "총 수익률은 %s%%입니다.";

    public void printPurchasedLottos(List<Lotto> purchasedLottos) {
        StringBuilder message = new StringBuilder();
        message.append(String.format(PURCHASED, purchasedLottos.size()));
        for (Lotto purchasedLotto : purchasedLottos) {
            appendPurchasedLotto(purchasedLotto, message);
        }
        System.out.println(message);
    }

    private void appendPurchasedLotto(Lotto purchasedLotto, StringBuilder message) {
        List<LottoNumber> numbers = purchasedLotto.getNumbers();
        List<LottoNumber> sortedNumbers = numbers.stream()
                .sorted()
                .toList();

        message.append(sortedNumbers).append("\n");
    }

    public void printWinningResult(Result winningResult) {
        StringBuilder message = new StringBuilder();
        message.append(WINNING_RESULT);
        appendStatistics(winningResult, message);
        appendRateOfReturn(winningResult, message);
        System.out.println(message);
    }

    private static void appendStatistics(Result winningResult, StringBuilder message) {
        for (Entry<Rank, Integer> rankIntegerEntry : winningResult.getRankToCount().entrySet()) {
            message.append(rankIntegerEntry.getKey().getMatchCount()).append(MATCH_COUNT);

            if (rankIntegerEntry.getKey().hasBonus()) {
                message.append(HAS_BONUS);
            }

            long prize = rankIntegerEntry.getKey().getPrize();
            Integer value = rankIntegerEntry.getValue();
            message.append(String.format(PRIZE_COUNT, DECIMAL_FORMAT.format(prize), value));
        }
    }

    private void appendRateOfReturn(Result winningResult, StringBuilder message) {
        BigDecimal rateOfReturn = winningResult.getRateOfReturn();
        message.append(String.format(RATE_OF_RETURN, rateOfReturn.toPlainString()));
    }
}
