package lotto.Controller;

import lotto.Domain.*;
import lotto.Domain.Generator.LottoGenerator;
import lotto.View.InputBouns;
import lotto.View.InputBuyLotto;
import lotto.View.InputPrizeLotto;

import java.util.List;

import static lotto.View.outputBuyLottocount.printBuyLotto;
import static lotto.View.outputLottoList.printLottoList;
import static lotto.View.outputResult.printStatistics;

public class LottoController {

    public void start(){
        Money money = getLottoMoney();
        printBuyLotto(money);

        Lottos lottos = getLottos(money);
        printLottoList(lottos);

        WinningLotto winningLotto = getWinningLotto();
        RankResult rankResult = new RankResult();
        calcLottoResult(rankResult, winningLotto, lottos);

        Rate rate = getRate(money, rankResult);
        printStatistics(rankResult,rate);
    }

    private Money getLottoMoney(){
        InputBuyLotto inputBuyLotto = new InputBuyLotto();
        int money = inputBuyLotto.getValue();
        return new Money(money);
    }

    private Lottos getLottos(Money money){
        LottoGenerator lottoGenerator = new LottoGenerator();
        return new Lottos(lottoGenerator.generateLottoGroup(money.getTicket()));
    }

    private WinningLotto getWinningLotto() {
        InputPrizeLotto inputPrizeLotto = new InputPrizeLotto();
        InputBouns inputBouns = new InputBouns();

        List<Integer> prizenumbers = inputPrizeLotto.getValue();
        Integer bounsNumber = inputBouns.getValue();

        return new WinningLotto(prizenumbers,bounsNumber);
    }

    private void calcLottoResult(RankResult rankResult, WinningLotto winningLotto, Lottos lottos){
            rankResult.calcRankResult(winningLotto,lottos);
    }

    private Rate getRate(Money money, RankResult rankResult){
        return new Rate(money, rankResult);
    }
}
