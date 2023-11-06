package lotto.DiContainer;

import java.util.List;
import lotto.Controller.LottoController;
import lotto.Domain.Lotto;
import lotto.Domain.LottoGroup;
import lotto.Domain.LottoResult.LottoResult;
import lotto.Domain.Money;
import lotto.Domain.WinningLotto.BonusNumber;
import lotto.Domain.WinningLotto.WinningLotto;
import lotto.Model.LottoResultHandlerModel;
import lotto.VIew.InputView;
import lotto.VIew.InputViewImpl;
import lotto.VIew.OutputView;
import lotto.VIew.OutputViewImpl;

public class DiContainer {

    private DiContainer() {
    }

    public static DiContainer of() {
        return new DiContainer();
    }

    public LottoController getLottoController() {
        return LottoController.of();
    }

    public LottoResultHandlerModel getLottoResultHandlerModel(WinningLotto winningLotto, LottoGroup lottoGroup) {
        return LottoResultHandlerModel.of(winningLotto, lottoGroup);
    }

    public InputView getInputView() {
        return InputViewImpl.of();
    }

    public OutputView getOutputView() {
        return OutputViewImpl.of();
    }

}
