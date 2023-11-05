package lotto.controller;

import lotto.constants.Message;
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
        createUserLottos();
        createWinningLotto();
        showResult();
    }

    private void createUserLottos() {
        int amount = inputService.inputAmount();
        lottoService.createUserLottos(amount);
        lottoService.showUserLottos();
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
