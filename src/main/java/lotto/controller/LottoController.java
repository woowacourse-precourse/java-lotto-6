package lotto.controller;

import java.util.List;

import lotto.dto.LottoDto;
import lotto.dto.LottoResultDto;
import lotto.model.LottoBuyer;
import lotto.model.LottoManager;
import lotto.model.LottoResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoManager lottoManager;

    public LottoController(final InputView inputView, final OutputView outputView, final LottoManager lottoManager) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoManager = lottoManager;
    }

    public void run() {
        final LottoBuyer lottoBuyer = buyLotto();
        final LottoResult lottoResult = announceWinningLotto();
        confirmLottoWinning(lottoBuyer, lottoResult);
    }

    private LottoBuyer buyLotto() {
        final int amount = inputView.readAmount();
        final LottoBuyer lottoBuyer = new LottoBuyer(amount, lottoManager);
        final List<LottoDto> lottos = lottoBuyer.getLottos();
        outputView.printLottos(lottos);
        return lottoBuyer;
    }

    private LottoResult announceWinningLotto() {
        final List<Integer> inputWinningNumbers = inputView.readWinningNumbers();
        final int inputBonusNumber = inputView.readBonusNumber(inputWinningNumbers);
        return new LottoResult(inputWinningNumbers, inputBonusNumber, lottoManager);
    }

    private void confirmLottoWinning(final LottoBuyer lottoBuyer, final LottoResult lottoResult) {
        final List<LottoResultDto> lottoResults = lottoBuyer.calculateResult(lottoResult);
        final double returnOnInvestment = lottoBuyer.returnOnInvestment();
        outputView.printResult(lottoResults);
        outputView.printReturnOnInvestment(returnOnInvestment);
    }
}
