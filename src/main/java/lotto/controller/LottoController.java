package lotto.controller;

import java.util.List;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.WinnerLotto;
import lotto.service.LottoService;
import lotto.service.LottoWinnerService;
import lotto.view.InputView;

public class LottoController {

    private final InputView inputView = new InputView();
    private final LottoService lottoService = new LottoService();
    private final LottoWinnerService lottoWinnerService = new LottoWinnerService();
    private LottoTicket lottoTicket = new LottoTicket();
    private WinnerLotto winnerLotto;

    public void buyLotto() {
        int price;
        int lottoAmount;

        price = inputView.getLottoPrice();
        lottoAmount = lottoService.getLottoAmount(price);
        lottoTicket = lottoService.exchangeLotto(lottoAmount);
    }

    public void setLottoWinner() {
        List<Integer> winnerNumber;
        int bonusNumber;

        winnerNumber = inputView.getWinnerLotto();
        bonusNumber = inputView.getBonusNumber();
        winnerLotto = new WinnerLotto(winnerNumber, bonusNumber);

    }

    public void endLotto() {
        lottoWinnerService.checkWinner(lottoTicket, winnerLotto);
    }
}
