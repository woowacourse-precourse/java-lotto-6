package lotto.controller.subcontroller;

import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.domain.repository.LottoResultRepository;
import lotto.domain.repository.WinningLottoRepository;
import lotto.view.InputView;
import lotto.view.OutputView;

public class CompareResultController implements Controllable {
    private final InputView inputView;
    private final OutputView outputView;

    public CompareResultController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void process() {
        WinningLotto winningLotto = WinningLottoRepository.findWiningLotto();

        LottoResult lottoResult = new LottoResult(winningLotto.compare());
        LottoResultRepository.add(lottoResult);

        outputView.outputLottoResults(lottoResult);
    }
}
