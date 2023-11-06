package lotto.controller;

import lotto.domain.Ranking;
import lotto.service.LottoService;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        Integer price = inputView.getPrice();
        ArrayList<Lotto> lottos = lottoService.getLottos(price);
        outputView.printLottos(lottoService.getLottoList(lottos), lottos.size());

        Lotto winningNumber = inputView.getWinningNumber();
        Integer bonusNumber = inputView.getBonusNumber(winningNumber);

        HashMap<Ranking, Integer> winningStatic = lottoService.getWinningStatic(lottos, winningNumber, bonusNumber);
        outputView.printWinningStatic(lottoService.makeWinningStaticResult(winningStatic));

        Double rateOfReturn = lottoService.getRateOfReturn(price, winningStatic);
        outputView.printRateOfReturn(rateOfReturn);
    }
}
