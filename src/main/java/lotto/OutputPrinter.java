package lotto;

import java.util.List;

public class OutputPrinter {
    public static void printLotteries (int numPurchase, List<Lotto> Lotteries) {
        System.out.printf("%d개를 구매했습니다.%n", numPurchase);
        for (int i = 0; i < numPurchase; i++)  {
            System.out.println(Lotteries.get(i).toString());
        }
    }
}
