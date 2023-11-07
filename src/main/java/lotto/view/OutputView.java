package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;

public class OutputView {

    private final static String PRINT_BUY_AMOUNT = "%d개를 구매했습니다.\n";
    private final static String PRINT_REVENUE = "총 수익률은 %.1f%%입니다.\n";
    private final static String PRINT_WINNING = "당첨 통계";
    private final static String PRINT_LINE = "---";

    public void printWinning(List<Integer> winning, int purchaseMoney) {
        System.out.println(PRINT_WINNING);
        System.out.println(PRINT_LINE);
        printRevenue(winning.get(5), purchaseMoney);
    }

    private void printRevenue(int winningMoney, int purchaseMoney) {
        double revenue = (double) (winningMoney - purchaseMoney) / purchaseMoney * 100;
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
