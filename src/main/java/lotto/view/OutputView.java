package lotto.view;

import lotto.model.Lotto;
import lotto.model.Statistics;

import java.util.List;

public class OutputView {
    public static void printInputMoneyMsg() {
        System.out.println("구입금액을 입력해 주세요.");
    }
    public static void printNextLine() {
        System.out.println("");
    }
    public static void printAmountOfLottoTickets(int amountOfLottoTickets) {
        System.out.printf("%d개를 구매했습니다.\n", amountOfLottoTickets);
    }
    public static void printLottoTickets(List<Lotto> lottoTickets) {
        for (Lotto lotto : lottoTickets) {
            List<Integer> numbers = lotto.getNumbers();
            System.out.println(numbers.toString());
        }
    }
    public static void printInputWinningNumbersMsg() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
    public static void printInputBonusNumberMsg() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
    public static void printStatistics(List<Statistics> lottoStatistics) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for(Statistics statistics : lottoStatistics) {
            System.out.printf("%s - %d개 \n", statistics.getValue(), statistics.getAmountOfTickets());
        }
    }
    public static void printEarningRate(double earningRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", earningRate);
    }
}
