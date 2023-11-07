package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.UserLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.EnumMap;
import java.util.List;

public class LottoController {

    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;


    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printRequestPurchasePrice();
        String inputLottoPrice = inputView.inputLottoPrice();
        int price = Integer.parseInt(inputLottoPrice);

        int lottoSheets = lottoService.calculateLottoSheet(price);
        outputView.printLottoQuantity(lottoSheets);
        List<Lotto> lottos = lottoService.generateLotto(lottoSheets);
        outputView.printLottoNumbers(lottos);

        outputView.printRequestLottoNumbers();
        String inputLottoNumbers = inputView.inputLottoNumbers();

        outputView.printRequestBonusNumber();
        String inputLottoBonusNumber = inputView.inputLottoBonusNumber();

        UserLotto userLotto = lottoService.purchaseLotto(inputLottoNumbers, inputLottoBonusNumber);

        EnumMap<LottoRank, Integer> lottoResult = lottoService.getLottoResult(lottos, userLotto);

        outputView.printLotteryResult(lottoResult);

        double ratio = lottoService.calculatePrizeRatio(lottoResult, price);

        outputView.printPrizeRatio(ratio);

    }
}
