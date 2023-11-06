package lotto.Controller;

import lotto.DiContainer.DiContainer;
import lotto.Domain.LottoGroup;
import lotto.Domain.Money;
import lotto.Domain.WinningLotto.WinningLotto;
import lotto.Model.LottoResultHandlerModel;
import lotto.VIew.InputView;
import lotto.VIew.OutputView;

public class LottoController {

    private final DiContainer diContainer = DiContainer.of();
    private final InputView inputView = diContainer.getInputView();
    private final OutputView outputView = diContainer.getOutputView();

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

    protected Money getMoney() {
        String inputMoney = inputView.inputMoney();
        return Money.from(inputMoney);
    }

    private LottoGroup getLottoGroup(Money money) {
        LottoGroup lottoGroup = LottoGroup.from(money);
        outputView.printLottoCount(lottoGroup.findLottoNumbersSize());
        outputView.printOrderedLottos(lottoGroup);
        return lottoGroup;
    }

    private WinningLotto getWinningLotto() {
        WinningLotto winningLotto = WinningLotto.of();
        createWinningLottoNumber(winningLotto);
        createWinningBonusNumber(winningLotto);
        return winningLotto;
    }

    protected void createWinningBonusNumber(WinningLotto winningLotto) {
        String inputBonusNumber = inputView.inputBonusNumber();
        winningLotto.setBonusNumber(inputBonusNumber);
    }

    protected void createWinningLottoNumber(WinningLotto winningLotto) {
        String inputWinningNumber = inputView.inputWinningNumber();
        winningLotto.setLotto(inputWinningNumber);
    }

}
