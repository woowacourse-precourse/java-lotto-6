package lotto.controller;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void play() {
        outputView.printPurchaseAmount();
        int purchaseAmount = Integer.parseInt(inputView.readPurchaseAmount());

        List<Lotto> lottos = lottoService.createLottos(purchaseAmount);
        outputView.printLottoCount(lottos.size());
        lottos.forEach((lotto -> outputView.printLottoNumbers(lotto.getNumbers())));

        outputView.printLotteryNumbers();
        List<Integer> lotteryNumbers = Arrays.stream(inputView.readLottryNumbers().split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();

        outputView.printBonusNumber();
        int bonusNumber = Integer.parseInt(inputView.readBonusNumber());
    }
}
