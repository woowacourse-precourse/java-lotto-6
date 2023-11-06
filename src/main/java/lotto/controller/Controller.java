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
        while (true) {
            try {
                List<Integer> winningLottoNumbers = inputService.inputWinningLottoNumbers();
                WinningLotto winningLotto = new WinningLotto(winningLottoNumbers);

                lottoResultService.setWinningLotto(winningLotto);
                int winningBonusNumber = inputService.inputWinningBonusNumber(winningLotto);

                winningLotto.setBonusNumber(winningBonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.WINNING_NUMBER_FORMAT);
            }
        }
    }

    private void showResult() {
        List<Lotto> buyLottos = lottoService.getBuyLottos();

        lottoResultService.showRank(buyLottos);

        int payMoney = buyLottos.size() * Value.LOTTO_TICKET_PRICE;
        lottoResultService.showProfitRate(payMoney);
    }
}
