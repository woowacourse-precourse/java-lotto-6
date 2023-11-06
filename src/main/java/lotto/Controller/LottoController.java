package lotto.Controller;

import lotto.Domain.LottoGroup;
import lotto.Domain.Money;
import lotto.Domain.WinningLotto.WinningLotto;
import lotto.Model.LottoResultHandlerModel;
import lotto.VIew.InputView;
import lotto.VIew.InputViewImpl;
import lotto.VIew.OutputView;
import lotto.VIew.OutputViewImpl;

public class LottoController {

    private final InputView inputView = new InputViewImpl();
    private final OutputView outputView = new OutputViewImpl();
    private LottoResultHandlerModel lottoResultHandlerModel;

    public void startProcess(){
        Money money = getMoney();
        LottoGroup lottoGroup = getLottoGroup(money);
        WinningLotto winningLotto = getWinningLotto();
        lottoResultHandlerModel = new LottoResultHandlerModel(winningLotto, lottoGroup);
        outputView.printLottoResult(lottoResultHandlerModel.getLottoResult());
        outputView.printProfitRate(lottoResultHandlerModel.findProfitRate());
    }

    private WinningLotto getWinningLotto() {
        String inputWinningNumber = inputView.inputWinningNumber();
        String inputBonusNumber = inputView.inputBonusNumber();
        return new WinningLotto(inputWinningNumber, inputBonusNumber);
    }

    private LottoGroup getLottoGroup(Money money) {
        LottoGroup lottoGroup = LottoGroup.from(money);
        outputView.printLottoCount(lottoGroup.findLottoNumbersSize());
        outputView.printOrderedLottos(lottoGroup);
        return lottoGroup;
    }

    private Money getMoney() {
        String inputMoney = inputView.inputMoney();
        Money money = new Money(inputMoney);
        return money;
    }
}
