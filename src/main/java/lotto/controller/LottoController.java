package lotto.controller;

import java.util.List;
import lotto.dto.LottoStatistics;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        buyLotto();
        setWinningNumbers();
        getWinningStatistic();
    }

    public void buyLotto(){
        int purchaseAmount = inputView.inputLottoPurchaseAmount();
        lottoService.buyLotto(purchaseAmount);

        outputView.printLottoNumbers(lottoService.getMyLotto());
    }

    public void setWinningNumbers(){
        List<Integer> winningNumbers = inputView.inputLottoWinningNumbers();
        int bonusNumber = inputView.inputLottoBonusNumber();

        lottoService.saveWinningNumbers(winningNumbers, bonusNumber);
    }

    public void getWinningStatistic(){
        LottoStatistics lottoStatistics = lottoService.calcLotto();

        outputView.printLottoStatistics(lottoStatistics);
    }
}
