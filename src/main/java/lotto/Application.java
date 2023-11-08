package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int purchaseMoney = InputReader.askPurchaseMoney();
        int numPurchase = purchaseMoney / 1000;

        List<Lotto> Lotteries = LottoGenerator.getSeveralLotteries(numPurchase);

        OutputPrinter.printLotteries(numPurchase, Lotteries);

        Lotto targetLotto = InputReader.askTargetLotto();

        int bonusNumber = InputReader.askBonusNumber(targetLotto);

        System.out.println(bonusNumber);
    }
}
