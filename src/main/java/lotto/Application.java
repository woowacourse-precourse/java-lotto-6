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
        int total;

        buyLotto(purchase);
        generateLotto(lottos,purchase);
        inputWinNumber(prizeNumber);
        total =result(lottos,prizeNumber);
        calculateYield(total,purchase);
    }
    static void buyLotto(Purchase purchase){
        Message.start();
        purchase.Number(UserInput.purchasePrice());
        Message.printCount(purchase.getPurchaseCount());

    }
    static void generateLotto(Lottos lottos,Purchase purchase){
        lottos.initLottos(LottoGenerator.createLottos(purchase.getPurchaseCount()));
        Message.printLotto(lottos);
    }
    static void inputWinNumber(PrizeNumber prizeNumber){
        Message.inputPrize();
        prizeNumber.initPrizeNumber(UserInput.prizeNumber());

        Message.inputBonus();
        prizeNumber.initBonusNumber(UserInput.bonusNumber());
    }
    static int result(Lottos lottos, PrizeNumber prizeNumber){
        int total;
        PrizeChecker prizeChecker =new PrizeChecker();
        Ranking ranking;

        Message.printOuttro();
        ranking = prizeChecker.checkRank(lottos, prizeNumber);
        total = YieldCalculator.totalPrize(ranking);

        ranking.calculateResult();
        ranking.printResult();

        return total;
    }
    static void calculateYield(int total,Purchase purchase){
        YieldCalculator.yieldcalculate(total, purchase.getPurchasePrice());
    }


}
