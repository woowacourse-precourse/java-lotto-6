package lotto;

import controller.LottoGenerator;
import controller.PrizeChecker;
import controller.UserInput;
import controller.YieldCalculator;
import model.*;

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

        purchase.Number(UserInput.purchasePrice());
        System.out.println(purchase.getPurchaseCount());

        lottos.initLottos(LottoGenerator.createLottos(purchase.getPurchaseCount()));
        for(Lotto l : lottos.getLottos()){
            System.out.println(l);
        }
        System.out.println(lottos.getLottos().size());

        prizeNumber.initPrizeNumber(UserInput.prizeNumber());
        System.out.println(prizeNumber.getPrizeNumber());

        prizeNumber.initBonusNumber(UserInput.bonusNumber());
        System.out.println(prizeNumber.getBonousNumber());

        ranking = prizeChecker.checkRank(lottos,prizeNumber);
        System.out.println(ranking.getWinningDetails());

        System.out.println(YieldCalculator.totalPrize(ranking));

    }



}
