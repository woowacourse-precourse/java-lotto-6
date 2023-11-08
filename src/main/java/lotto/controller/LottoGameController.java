package lotto.controller;

import java.util.List;
import lotto.domain.BuyCash;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.Result;
import lotto.domain.WinningLotto;
import lotto.service.BuyCashService;
import lotto.service.LottoService;
import lotto.service.ResultService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BuyCashService buyCashService;
    private final LottoService lottoService;
    private final ResultService resultService;

    public LottoGameController(InputView inputView, OutputView outputView, BuyCashService buyCashService,
                               LottoService lottoService, ResultService resultService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.buyCashService = buyCashService;
        this.lottoService = lottoService;
        this.resultService = resultService;
    }

    public BuyCash inputBuyCash() {
        BuyCash buycash;
        while (true) {
            try {
                buycash = buyCashService.generateBuyCash(inputView.inputBuyCashFromUser());
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return buycash;
    }

    public Lottos purchaseLotto(BuyCash buyCash) {
        long buyAmount = buyCash.getLottoAmount();
        List<Lotto> lottos = lottoService.generateAutoLottos(buyAmount);

        return new Lottos(lottos);
    }

    public void printBuyLottosInformation(Lottos lottos) {
        outputView.printUserLottos(lottos.getAllLottoNumbersMessage(), lottos.getLottoAmount());
    }

    public Lotto inputWinningLotto() {
        Lotto winningNumbers;

        while (true) {
            try {
                winningNumbers = lottoService.generateManualLotto(inputView.inputWinningNumbers());
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }

        return winningNumbers;
    }

    public LottoNumber inputBonusNumber() {
        long bonusNumber = inputView.inputBonusNumberFromUser();
        return lottoService.generateLottoNumber(bonusNumber);
    }

    public Result getResult(Lottos lottos, WinningLotto winningLotto) {
        return resultService.generate(lottos, winningLotto);
    }

    public void printWinningResult(Result result, BuyCash buyCash) {
        outputView.printWinningResult(result.getAllRankStatistics(),
                buyCash.getTotalProfitRate(result.getTotalProfit()));
    }
}
