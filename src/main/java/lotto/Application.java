package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.insertMoneyView();
        List<Lotto> lottoBundle = lottoMachine.lottoBundleView();

        LottoResultChecker lottoResultChecker = new LottoResultChecker();
        lottoResultChecker.enterWinAndBonusNumbersView();

    }


}
