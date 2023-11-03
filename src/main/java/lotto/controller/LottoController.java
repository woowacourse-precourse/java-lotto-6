package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.PurchasedLotto;
import lotto.service.LottoResultService;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.IntStream;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;
    private final LottoResultService resultService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService, LottoResultService resultService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
        this.resultService = resultService;
    }

    public void run() {
        Integer lottoCount = purchaseLotto();
        PurchasedLotto purchasedLotto = purchaseLottoByLottoCount(lottoCount);

    }

    private PurchasedLotto purchaseLottoByLottoCount(Integer lottoCount) {
        PurchasedLotto purchasedLotto = new PurchasedLotto();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> randomNumbers = lottoService.createRandomNumbers();
            purchasedLotto.addLotto(new Lotto(randomNumbers));
        }

        outputView.purchaseLottoNumbers(purchasedLotto);

        return purchasedLotto;
    }

    private Integer purchaseLotto() {
        outputView.purchaseLottoMessage();
        Integer inputMoney = inputView.purchaseLotto();

        Integer lottoCount = lottoService.purchaseLottoWithValidPrice(inputMoney);
        outputView.purchaseLottoCountMessage(lottoCount);

        return lottoCount;
    }
}
