package lotto;

import lotto.model.AutoLottoGenerator;
import lotto.model.LottoBuyer;
import lotto.model.LottoGenerator;
import lotto.model.LottoRankResult;
import lotto.model.LottoSeller;
import lotto.service.LottoGameService;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.console.ConsoleInputView;
import lotto.view.console.ConsoleOutputView;

public class ApplicationConfig {
    public LottoGameService lottoGameService() {
        return new LottoGameService(inputView(), outputView(), lottoRankResult());
    }

    public InputView inputView() {
        return new ConsoleInputView();
    }

    public OutputView outputView() {
        return new ConsoleOutputView();
    }

    public LottoRankResult lottoRankResult() {
        return new LottoRankResult();
    }

    public LottoGenerator lottoGenerator() {
        return AutoLottoGenerator.getInstance();
    }

    public LottoSeller lottoSeller() {
        return new LottoSeller(lottoGenerator());
    }

    public LottoBuyer lottoBuyer() {
        return new LottoBuyer();
    }
}
