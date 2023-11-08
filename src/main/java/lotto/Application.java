package lotto;

import java.util.List;

import static lotto.OutputPrinter.printRankingMessage;
import static lotto.OutputPrinter.printResult;

public class Application {
    public static void main(String[] args) {
        int purchaseMoney = InputReader.askPurchaseMoney();
        int numPurchase = purchaseMoney / 1000;
        List<Lotto> Lotteries = LottoGenerator.getSeveralLotteries(numPurchase);
        OutputPrinter.printLotteries(numPurchase, Lotteries);
        Lotto targetLotto = InputReader.askTargetLotto();
        int bonusNumber = InputReader.askBonusNumber(targetLotto);

        List<Integer> prizes = LottoResults.getLottoResults(Lotteries, targetLotto, bonusNumber);

        printResult();

    }
}
