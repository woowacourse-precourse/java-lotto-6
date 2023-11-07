package lotto.controller;

import lotto.domain.Constants;
import lotto.domain.Ranking;
import lotto.service.LottoService;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
        ArrayList<Lotto> lottos = lottoService.getLottos(price, Constants.MIN_LOTTO_NUM, Constants.MAX_LOTTO_NUM);
        outputView.printLottos(lottoService.getLottoList(lottos), lottos.size());

        List<Integer> winningNumber = inputView.getWinningNumber();
        Integer bonusNumber = inputView.getBonusNumber(winningNumber);
        Lotto winningLotto = new Lotto(winningNumber);

        HashMap<Ranking, Integer> winningStatic = lottoService.getWinningStatic(lottos, winningLotto, bonusNumber);
        outputView.printWinningStatic(lottoService.makeWinningStaticResult(winningStatic));

        Double rateOfReturn = lottoService.getRateOfReturn(price, winningStatic);
        outputView.printRateOfReturn(rateOfReturn);
    }
}
