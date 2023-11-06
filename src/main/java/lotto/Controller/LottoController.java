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

    private final InputView inputView;
    private final OutputView outputView;
    private LottoResultHandlerModel lottoResultHandlerModel;

    private LottoController() {
        inputView = InputViewImpl.of();
        outputView = OutputViewImpl.of();
    }

    public static LottoController of(){
        return new LottoController();
    }

    public void startProcess(){
        Money money = getMoney();
        LottoGroup lottoGroup = getLottoGroup(money);
        WinningLotto winningLotto = getWinningLotto();
        lottoResultHandlerModel = LottoResultHandlerModel.of(winningLotto, lottoGroup);

        outputView.printLottoResult(lottoResultHandlerModel.getLottoResult());
        outputView.printProfitRate(lottoResultHandlerModel.findProfitRate());
    }

    private Money getMoney() {
        String inputMoney = inputView.inputMoney();
        return Money.from(inputMoney);
    }

    private WinningLotto getWinningLotto() {
        String inputWinningNumber = inputView.inputWinningNumber();
        String inputBonusNumber = inputView.inputBonusNumber();
        return WinningLotto.of(inputWinningNumber, inputBonusNumber);
    }

    private LottoGroup getLottoGroup(Money money) {
        LottoGroup lottoGroup = LottoGroup.from(money);
        outputView.printLottoCount(lottoGroup.findLottoNumbersSize());
        outputView.printOrderedLottos(lottoGroup);
        return lottoGroup;
    }

}
