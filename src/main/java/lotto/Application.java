package lotto;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {

        Amount amount = new Amount();
        Draw draw = new Draw();
        Print print = new Print();

        int money = amount.enterAmount();
        List<Lotto> lottos = draw.issueLottos(money);
        print.printPurchasedLottos(lottos);

        Lotto winningLotto = draw.enterWinningLottoNums();
        int bonusNum = draw.enterBonusNum(winningLotto);

        Map<Rank, Integer> drawResult = draw.draw(winningLotto, bonusNum, lottos);
        print.printDrawResultStats(money, drawResult);
    }
}
