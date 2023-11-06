package lotto.controller;

import java.util.HashMap;
import java.util.List;
import lotto.domain.lotto.LottoRank;
import lotto.domain.lotto.WinnerLotto;
import lotto.repository.LottoRepository;
import lotto.service.LottoBuyService;
import lotto.service.LottoWinnerService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoBuyService lottoService = new LottoBuyService();
    private final LottoWinnerService lottoWinnerService = new LottoWinnerService();
    private LottoRepository lottoRepository = LottoRepository.getInstance();
    private WinnerLotto winnerLotto;

    public void buyLotto() {
        int price;
        int lottoAmount;

        price = inputView.getLottoPrice();
        lottoAmount = lottoService.getLottoAmount(price);
        lottoRepository = lottoService.exchangeLotto(lottoAmount);
    }

    public void setLottoWinner() {
        List<Integer> winnerNumber;
        int bonusNumber;

        winnerNumber = inputView.getWinnerLotto();
        bonusNumber = inputView.getBonusNumber();
        winnerLotto = new WinnerLotto(winnerNumber, bonusNumber);

    }

    public void endLotto() {
        List<LottoRank> rankResult = lottoWinnerService.checkRanking(winnerLotto);
        HashMap<LottoRank, Integer> lottoResult = lottoWinnerService.setLottoResult(
            rankResult);

    }
}
