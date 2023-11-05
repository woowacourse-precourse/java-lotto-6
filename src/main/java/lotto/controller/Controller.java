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
        showRank();
        showProfitRate();
    }

    private void createUserLottos() {
        int amount = inputService.inputAmount();
        lottoService.createUserLottos(amount);

        showUserLottos();
    }

    private void showUserLottos() {
        List<Lotto> userLottos = lottoService.getUserLottos();

        System.out.println("\n" + userLottos.size() + Message.USER_LOTTOS_COUNT_MESSAGE);

        for (Lotto lotto : userLottos) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    private void createWinningLotto() {
        WinningLotto winningLotto = inputService.inputWinningLotto();
        lottoResultService.setWinningLotto(winningLotto);
    }

    private void showRank() {
        System.out.println(Message.LOTTO_RESULT_MESSAGE);

        List<Lotto> userLottos = lottoService.getUserLottos();
        lottoResultService.calculateLottoResult(userLottos);
        lottoResultService.showResult();
    }

    private void showProfitRate() {
        int amount = lottoService.getUserLottoSize() * Value.LOTTO_TICKET_PRICE;
        String profitRate = lottoResultService.getProfitRate(amount);
        System.out.println(Message.getLottoProfitRate(profitRate));
    }

}
