package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;

public class OutputView {

    private final static String PRINT_BUY_AMOUNT = "\n%d개를 구매했습니다.\n";
    private final static String PRINT_REVENUE = "총 수익률은 %.1f%%입니다.\n";
    private final static String PRINT_WINNING = "\n당첨 통계";
    private final static String PRINT_LINE = "---";
    private final static List<String> PRINT_WINNING_COUNT = Arrays.asList(
            "3개 일치 (5,000원) - %d개\n",
            "4개 일치 (50,000원) - %d개\n",
            "5개 일치 (1,500,000원) - %d개\n",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n",
            "6개 일치 (2,000,000,000원) - %d개\n"
    );

    public void printWinning(List<Integer> winning, int purchaseMoney) {
        System.out.println(PRINT_WINNING);
        System.out.println(PRINT_LINE);
        printWinningCount(winning);
        printRevenue(winning.get(5), purchaseMoney);
    }

    private void printWinningCount(List<Integer> winning) {
        for (int i = 0; i < 5; i++) {
            System.out.printf(PRINT_WINNING_COUNT.get(i), winning.get(i));
        }
    }

    private void printRevenue(int winningMoney, int purchaseMoney) {
        double revenue = (double) winningMoney / purchaseMoney * 100;
        System.out.printf(PRINT_REVENUE, revenue);
    }

    public void printLottoBundle(List<Lotto> lottoBundle) {
        int buyAmount = lottoBundle.size();
        List<Integer> numbers;
        printBuyAmount(buyAmount);
        for (Lotto lotto : lottoBundle) {
            numbers = lotto.getNumbers();
            printLotto(numbers);
        }
    }

    private void printLotto(List<Integer> numbers) {
        String numbersLine = numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(numbersLine);
    }

    private void printBuyAmount(int buyAmount) {
        System.out.printf(PRINT_BUY_AMOUNT, buyAmount);
    }


}
