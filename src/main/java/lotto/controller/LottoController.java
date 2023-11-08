package lotto.controller;

import lotto.model.LottoCompare;
import lotto.model.LottoMaker;
import lotto.model.LottoRank;
import lotto.model.LottoResult;
import lotto.model.Ratio;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {

    public void run(){
        int money;
        LottoMaker lottoMaker;
        Output.printMoney();
        money = Input.moneyInput();
        lottoMaker = new LottoMaker(money);
        Output.printBuylotto(money);
        Output.printlottos(lottoMaker);

        LottoCompare lottoCompare = new LottoCompare();
        Output.printWinning();
        lottoCompare.setWinningNumbers(Input.winnigInput());
        System.out.println();
        Output.printBonus();
        lottoCompare.setBonusNumber(Input.bonusInput());
        System.out.println();

        LottoResult lottoResult = new LottoResult();
        lottoResult.addLottos(lottoMaker,lottoCompare);
        Output.printEnd();
        Output.printResults(lottoResult);

        Ratio ratio = new Ratio(money,lottoResult);
        Output.printRatio(ratio);
    }
}
