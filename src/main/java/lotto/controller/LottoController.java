package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lotto.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoService lottoService = new LottoService();
    public void run() {
        List<Lotto> lottos = new ArrayList<>();

        String purchasePrice = inputView.buyLotto();
        int lottoAmount = lottoService.checkLottoNumber(purchasePrice);

        IntStream.range(0,lottoAmount)
                .forEach(i -> lottos.add(lottoService.generateLotto()));

        outputView.printBuyLotto(lottoAmount);
        outputView.printTotalLotto(lottos);
    }

}
