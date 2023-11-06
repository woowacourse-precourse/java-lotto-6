package lotto;

import controller.*;
import model.*;
import view.Input;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        run();
    }

    static void run(){
        Purchase purchase = new Purchase();
        Lottos lottos = new Lottos();
        PrizeNumber prizeNumber = new PrizeNumber();
        PrizeChecker prizeChecker = new PrizeChecker();
        Ranking ranking = new Ranking();

        Message.start();
        purchase.Number(UserInput.purchasePrice());

        Message.printCount(purchase.getPurchaseCount());
        lottos.initLottos(LottoGenerator.createLottos(purchase.getPurchaseCount()));
        Message.printLotto(lottos);

        Message.printPrize();
        prizeNumber.initPrizeNumber(UserInput.prizeNumber());

        Message.printBonus();
        prizeNumber.initBonusNumber(UserInput.bonusNumber());

        Message.printOuttro();

        ranking = prizeChecker.checkRank(lottos,prizeNumber);
        int total = YieldCalculator.totalPrize(ranking);
        ranking.calculateResult();
        ranking.printResult();

        YieldCalculator.yieldcalculate(total,purchase.getPurchasePrice());
    }



}
