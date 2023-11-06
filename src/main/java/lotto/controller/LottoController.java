package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;

public class LottoController {

    InputView inputView = new InputView();
    LottoService lottoService = new LottoService();

    public void buyLotto() {
        int price;
        int lottoAmount;
        List<Lotto> lottoTicket;

        price = inputView.getLottoPrice();
        lottoAmount = lottoService.getLottoAmount(price);
        lottoTicket = lottoService.exchangeLotto(lottoAmount);


    }

    public void setLottoWinner() {
        List<Integer> winnerLotto = new ArrayList<>();
        int bonusNumber;

        winnerLotto = inputView.getWinnerLotto();
        bonusNumber = inputView.getBonusNumber();


    }

    public void endLotto() {

    }
}
