package lotto.lotto;

import java.util.List;
import lotto.view.InputView;
import lotto.money.Money;
import lotto.money.MoneyUtils;
import lotto.view.OutputView;

public class LottoGame {

    public void start() {
        //로또구매
        Money purchaseAmount = InputView.inputMoney();
        List<Lotto> lottos = LottoMachine.buyLottos(purchaseAmount);
        OutputView.printLottos(lottos);

        //결과
        WinningNumber winningNumber = InputView.inputWinningNumber();
        OutputView.printResult(LottoMachine.getResult(winningNumber, lottos));

        //수익률
        Money earningAmount = LottoMachine.receiveMoney(winningNumber, lottos);
        Double yieldRate = MoneyUtils.calculateYieldRate(purchaseAmount, earningAmount);
        OutputView.printYieldRate(yieldRate);
    }

}
