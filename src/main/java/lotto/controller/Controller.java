package lotto.controller;

import lotto.constants.ErrorMessage;
import lotto.constants.Value;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.service.InputService;
import lotto.service.LottoResultService;
import lotto.service.LottoService;

import java.util.List;

public class Controller {

    InputService inputService = new InputService();
    LottoService lottoService = new LottoService();
    LottoResultService lottoResultService = new LottoResultService();

    public void run() {
        buyLotto();
        createWinningLotto();
        showResult();
    }


    private void buyLotto() {
        while (true) {
            try {
                int payMoney = inputService.inputPayMoney();
                lottoService.setBuyLotto(payMoney);

                break;
            } catch (IllegalArgumentException e){
                System.out.println(ErrorMessage.AMOUNT_FORMAT.getMessage());
            }
        }

        lottoService.showBuyLottos();
    }

    private void createWinningLotto() {
        WinningLotto winningLotto = inputService.inputWinningLotto();
        lottoResultService.setWinningLotto(winningLotto);
    }

    private void showResult() {
        List<Lotto> userLottos = lottoService.getUserLottos();

        lottoResultService.showRank(userLottos);

        int amount = userLottos.size() * Value.LOTTO_TICKET_PRICE;
        lottoResultService.showProfitRate(amount);
    }
}
