package lotto;

import java.util.List;

public class Print {
    private static final String HEADER = "당첨 통계\n---";
    private static final String TICKETS_PRINT = "\n%d개를 구매했습니다.\n";
    private static final String FIFTH_PRINT = "3개 일치 (5,000원) - %d개\n";
    private static final String FOURTH_PRINT = "4개 일치 (50,000원) - %d개\n";
    private static final String THIRD_PRINT = "5개 일치 (1,500,000원) - %d개\n";
    private static final String SECOND_PRINT = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    private static final String FIRST_PRINT = "6개 일치 (2,000,000,000원) - %d개\n";
    private static final String PROFIT_RATE_PRINT = "총 수익률은 %.1f%%입니다.\n";

    public static void tickets(Customer customer) {
        System.out.printf(TICKETS_PRINT, customer.amount);
        for (int i = 0; i < customer.amount; i++) {
            System.out.println(customer.tickets.get(i));
        }
    }

    public static void prizes(List<Long> numbersOfPrizes) {
        System.out.println(HEADER);
        System.out.printf(FIFTH_PRINT, numbersOfPrizes.get(4));
        System.out.printf(FOURTH_PRINT, numbersOfPrizes.get(3));
        System.out.printf(THIRD_PRINT, numbersOfPrizes.get(2));
        System.out.printf(SECOND_PRINT, numbersOfPrizes.get(1));
        System.out.printf(FIRST_PRINT, numbersOfPrizes.get(0));
    }

    public static void profitRate(int inputPrice, float totalProfit) {
        float profitRate = totalProfit / inputPrice * 100;
        System.out.printf(PROFIT_RATE_PRINT, profitRate);
    }
}
