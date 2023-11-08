package lotto;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {

        Amount amount = new Amount();
        LottoIssuer lottoIssuer = new LottoIssuer();
        Print print = new Print();

        int money = amount.enterAmount();
        List<Lotto> lottos = lottoIssuer.issueLottos(money);
        print.printPurchasedLottos(lottos);

        LottoMachine lottoMachine = new LottoMachine();
        Map<Rank, Integer> drawResult = lottoMachine.draw(lottos);
        print.printDrawResultStats(money, drawResult);
    }
}
