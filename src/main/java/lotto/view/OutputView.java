package lotto.view;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map.Entry;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Rank;
import lotto.dto.WinningResult;

public class OutputView {
    public static final String PURCHASED = "\n%d개를 구매했습니다.\n";
    public static final String WINNING_RESULT_INFORMATION = "\n당첨 통계\n---\n";
    public static final DecimalFormat PRIZE_FORMAT = new DecimalFormat("#,###");
    public static final String RATE_OF_RETURN = "총 수익률은 %s%%입니다.";
    public static final String WINNING_RESULT = "%d개 일치 (%s원) - %d개\n";
    public static final String WINNING_RESULT_HAS_BONUS = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";

    public void printPurchasedLottos(List<Lotto> purchasedLottos) {
        StringBuilder message = new StringBuilder();
        message.append(String.format(PURCHASED, purchasedLottos.size()));
        for (Lotto purchasedLotto : purchasedLottos) {
            message.append(purchasedLottoMessage(purchasedLotto)).append("\n");
        }
        System.out.print(message);
    }

    private String purchasedLottoMessage(Lotto purchasedLotto) {
        List<LottoNumber> numbers = purchasedLotto.getNumbers();
        List<LottoNumber> sortedNumbers = numbers.stream()
                .sorted()
                .toList();

        return sortedNumbers.toString();
    }

    public void printWinningResult(WinningResult winningResult) {
        StringBuilder message = new StringBuilder();
        message.append(WINNING_RESULT_INFORMATION);
        for (Entry<Rank, Integer> entry : winningResult.entrySet()) {
            message.append(winningResultMessage(entry.getKey(), entry.getValue()));
        }
        message.append(rateOfReturnMessage(winningResult));
        System.out.print(message);
    }

    private String winningResultMessage(Rank rank, Integer count) {
        if (rank.hasBonus()) {
            return String.format(WINNING_RESULT_HAS_BONUS, rank.getMatchCount(), prizeMessage(rank), count);
        }
        return String.format(WINNING_RESULT, rank.getMatchCount(), prizeMessage(rank), count);
    }

    private String prizeMessage(Rank rank) {
        return PRIZE_FORMAT.format(rank.getPrize());
    }

    private String rateOfReturnMessage(WinningResult winningResult) {
        BigDecimal rateOfReturn = winningResult.rateOfReturn();
        return String.format(RATE_OF_RETURN, rateOfReturn.toPlainString());
    }
}
