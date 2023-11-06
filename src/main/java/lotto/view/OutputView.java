package lotto.view;

import java.util.List;

public class OutputView {

    public static void buyLottoTicket() {
        System.out.println(OutputEnum.BUY_LOTTO_TICKET.get());
    }

    public static void getLottoCount(int count) {
        System.out.println(count + OutputEnum.GET_LOTTO_TICKET.get());
    }

    public static void printLottoTicket(List<String> lottoTickets) {
        for (String lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }

    public static void printWinningStatistics(List<String> winningStatistics) {
        for (String winningStatistic : winningStatistics) {
            System.out.println(winningStatistic);
        }
    }

    public static void printException(String message) {
        System.out.println(message);
    }

    public static void printEarningRate(String earningRate) {
        System.out.println(earningRate);
    }

    public static void numbersLotto() {
        System.out.println(OutputEnum.NUMBERS_LOTTO.get());
    }

    public static void bonusLotto() {
        System.out.println(OutputEnum.BONUS_LOTTO.get());
    }

    public static void resultLotto() {
        System.out.println(OutputEnum.RESULT_LOTTO.get());
    }
}
