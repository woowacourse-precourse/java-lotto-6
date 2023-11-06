package lotto.Controller;

import lotto.DiContainer.DiContainer;
import lotto.Domain.LottoGroup;
import lotto.Domain.Money;
import lotto.Domain.WinningLotto.WinningLotto;
import lotto.Model.LottoResultHandlerModel;
import lotto.VIew.InputView;
import lotto.VIew.OutputView;

public class LottoController {

    private final DiContainer diContainer;
    private final InputView inputView;
    private final OutputView outputView;

    private LottoController() {
        diContainer = DiContainer.of();
        inputView = diContainer.getInputView();
        outputView = diContainer.getOutputView();
    }

    public static LottoController of() {
        return new LottoController();
    }

    public void startProcess() {
        Money money = getMoney();
        LottoGroup lottoGroup = getLottoGroup(money);
        WinningLotto winningLotto = getWinningLotto();
        LottoResultHandlerModel lottoResultHandlerModel =
                diContainer.getLottoResultHandlerModel(winningLotto, lottoGroup);

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
