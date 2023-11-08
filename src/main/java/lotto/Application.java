package lotto;

import controller.*;
import model.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        run();
    }

    static void run() {
        Purchase purchase = new Purchase();
        Lottos lottos = new Lottos();
        PrizeNumber prizeNumber = new PrizeNumber();
        PrizeChecker prizeChecker = new PrizeChecker();
        Ranking ranking;
        int total;

        Message.start();
        purchase.Number(UserInput.purchasePrice());

        Message.printCount(purchase.getPurchaseCount());
        lottos.initLottos(LottoGenerator.createLottos(purchase.getPurchaseCount()));
        Message.printLotto(lottos);

        Message.inputPrize();
        prizeNumber.initPrizeNumber(UserInput.prizeNumber());

        Message.inputBonus();
        prizeNumber.initBonusNumber(UserInput.bonusNumber());

        Message.printOuttro();

        ranking = prizeChecker.checkRank(lottos, prizeNumber);
        total = YieldCalculator.totalPrize(ranking);
        ranking.calculateResult();
        ranking.printResult();

        YieldCalculator.yieldcalculate(total, purchase.getPurchasePrice());
    }


}
