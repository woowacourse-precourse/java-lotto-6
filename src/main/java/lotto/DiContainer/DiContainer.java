package lotto.DiContainer;

import lotto.Controller.LottoController;
import lotto.Decorator.LottoControllerDecorator;
import lotto.Domain.LottoGroup;
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
        return LottoControllerDecorator.of();
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
