package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int purchaseMoney = InputReader.askPurchaseMoney();
        int numPurchase = purchaseMoney / 1000;

        List<Lotto> Lotteries = LottoGenerator.getSeveralLotteries(numPurchase);



        System.out.println(numPurchase);
        for (int i = 0; i < numPurchase; i++)  {
            System.out.println(Lotteries.get(i).toString());
        }
    }
}
