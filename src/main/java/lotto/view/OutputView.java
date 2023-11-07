package lotto.view;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRanking;
import lotto.domain.LottoTickets;
import lotto.domain.Result;

public class OutputView {
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_NUMBER_OUTPUT_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String OPEN_BRACKET = "[";
    private static final String COMMA = ", ";
    private static final String CLOSE_BRACKET = "]";
    private static final String LOTTO_NUMBERS_INPUT_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS_OUTPUT_MESSAGE = "\n당첨 통계\n---";
    private static final String LOTTO_RESULT_MESSAGE = "%s%d개\n";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.\n";

    public static void printMoneyInputMessage() {
        printMessage(MONEY_INPUT_MESSAGE);
    }

    public static void printPurchaseAmountMessage(int ticketAmount) {
        System.out.printf(PURCHASE_NUMBER_OUTPUT_MESSAGE, ticketAmount);
    }

    public static void printLottoNumbers(int ticketAmount, LottoTickets lottoTickets) {
        printPurchaseAmountMessage(ticketAmount);
        lottoTickets.getLottoTickets()
                .forEach(lotto -> printMessage(createLottoTicket(lotto)));
    }

    private static String createLottoTicket(Lotto lotto) {
        StringBuilder lottoNumbers = new StringBuilder(OPEN_BRACKET);
        lotto.getNumbers()
                .forEach(number -> lottoNumbers.append(number)
                        .append(COMMA));
        lottoNumbers.delete(lottoNumbers.length() - 2, lottoNumbers.length());
        lottoNumbers.append(CLOSE_BRACKET);
        return lottoNumbers.toString();
    }

    public static void printLottoInputMessage() {
        printMessage(LOTTO_NUMBERS_INPUT_MESSAGE);
    }

    public static void printBonusNumberInputMessage() {
        printMessage(BONUS_NUMBER_INPUT_MESSAGE);
    }

    public static void printWinningStatusMessage() {
        printMessage(WINNING_STATISTICS_OUTPUT_MESSAGE);
    }

    public static void printLottoResultMessage(Result result) {
        filterAndSortResult(result)
                .forEach(Rank -> System.out.printf(LOTTO_RESULT_MESSAGE, Rank.getKey().getResultMessage(),
                        Rank.getValue()));
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.printf(RATE_OF_RETURN_MESSAGE, rateOfReturn);
    }

    private static List<Map.Entry<LottoRanking, Integer>> filterAndSortResult(Result result) {
        return result.getLottoResult().entrySet().stream()
                .filter(entry -> LottoRanking.NO_MATCH != entry.getKey())
                .sorted(Comparator.comparingInt(money -> money.getKey()
                        .getPrizeAmount())).toList();
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }
}
