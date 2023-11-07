package lotto.view;

import static lotto.view.constants.ConstantMessage.ALARM_HOW_MANY_BUY_LOTTO;
import static lotto.view.constants.ConstantMessage.ALARM_THE_RESULT_STARTING_MESSAGE;
import static lotto.view.constants.ConstantMessage.REQUEST_INPUT_BONUS_NUMBER;
import static lotto.view.constants.ConstantMessage.REQUEST_INPUT_LOTTO_NUMBERS;
import static lotto.view.constants.ConstantMessage.REQUEST_INPUT_PRICE;

import java.text.DecimalFormat;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.Prize;
import lotto.domain.PrizeRankConstants;
import lotto.view.constants.ConstantMessage;

public class ConsoleOutput {

    public static void askLottoAmount() {
        printConstantMessage(REQUEST_INPUT_PRICE);
    }

    public static void askLottoBonusNumber() {
        printConstantMessage(REQUEST_INPUT_BONUS_NUMBER);
    }

    public static void askWinningLottoNumbers() {
        printConstantMessage(REQUEST_INPUT_LOTTO_NUMBERS);
    }


    public static void printLottoTickets(LottoTicket lottoTicket) {
        Integer numberOfLotto = lottoTicket.getHowManyLotto();

        printLottoTickets(numberOfLotto, ALARM_HOW_MANY_BUY_LOTTO);
        for (Lotto lotto : lottoTicket.getLottos()) {
            printLottoNumbers(lotto);
        }
    }

    public static void printLottoPrizeResult(Prize result) {
        printConstantMessage(ALARM_THE_RESULT_STARTING_MESSAGE);

        for (PrizeRankConstants rank : PrizeRankConstants.values()) {
            Integer count = 0;

            if (result.contains(rank)) {
                count = result.getCount(rank);
            }
            printRankResultMessage(rank, count);
        }
    }

    public static void printLottoPrizeRateResult(Double result) {
        printLottoPrizeRateResultMessage(result);
    }

    public static void printError(Exception e) {
        printErrorMessage(e.getMessage());
    }

    private static void printErrorMessage(String error) {
        System.out.println("[ERROR] " + error);
    }

    private static void printLottoPrizeRateResultMessage(Double result) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.##%");
        System.out.println("총 수익률은 " + decimalFormat.format(result) + "입니다.");
    }

    private static void printRankResultMessage(
            PrizeRankConstants rank,
            Integer numOfRank
    ) {
        System.out.print(rank.getMessage());
        System.out.printf(" - %d개\n", numOfRank);
    }

    private static void printConstantMessage(ConstantMessage message) {
        System.out.println(message.getMessage());
    }

    private static void printLottoTickets(Integer numberOfLotto, ConstantMessage message) {
        System.out.println(numberOfLotto + message.getMessage());
    }

    private static void printLottoNumbers(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        System.out.println(numbers.toString());
    }
}
