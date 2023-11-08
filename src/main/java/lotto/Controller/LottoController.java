package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;
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
        Money money = inputMoney();
        LottoGroup lottoGroup = createLottoGroup(money);
        WinningLotto winningLotto = inputWinningLotto();
        LottoResultHandlerModel lottoResultHandlerModel =
                diContainer.getLottoResultHandlerModel(winningLotto, lottoGroup);

        outputView.printLottoResult(lottoResultHandlerModel.getLottoResult());
        outputView.printProfitRate(lottoResultHandlerModel.findProfitRate());
        Console.close();
    }

    protected Money inputMoney() {
        String inputMoney = inputView.inputMoney();
        return Money.from(inputMoney);
    }

    private LottoGroup createLottoGroup(Money money) {
        LottoGroup lottoGroup = LottoGroup.from(money);
        outputView.printLottoCount(lottoGroup.findLottoNumbersSize());
        outputView.printOrderedLottos(lottoGroup);
        return lottoGroup;
    }

    private WinningLotto inputWinningLotto() {
        WinningLotto winningLotto = WinningLotto.of();
        inputLottoNumber(winningLotto);
        inputWinningBonusNumber(winningLotto);
        return winningLotto;
    }

    protected void inputWinningBonusNumber(WinningLotto winningLotto) {
        String inputBonusNumber = inputView.inputBonusNumber();
        winningLotto.setBonusNumber(inputBonusNumber);
    }

    protected void inputLottoNumber(WinningLotto winningLotto) {
        String inputWinningNumber = inputView.inputWinningNumber();
        winningLotto.setLotto(inputWinningNumber);
    }

}
