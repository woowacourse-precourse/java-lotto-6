package lotto.controller;

import lotto.constants.Message;
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
        showUserLottos();
        createWinningLotto();
        showRank();
        showProfitRate();
    }

    private void showProfitRate() {
        int userLottoCount = lottoService.getUserLottoCount();
        String profitRate = lottoResultService.getProfitRate(userLottoCount);
        System.out.println(Message.getLottoProfitRate(profitRate));
    }

    private void showRank() {
        System.out.println(Message.LOTTO_RESULT_MESSAGE);

        List<Lotto> userLottos = lottoService.getUserLottos();
        lottoResultService.calculateLottoResult(userLottos);

        lottoResultService.showResult();
    }

    public void createUserLottos() {
        int lottoAmount = inputService.inputAmount();
        lottoService.createUserLottos(lottoAmount);
    }

    private void showUserLottos() {
        int userLottoCount = lottoService.getUserLottoCount();
        System.out.println("\n" + userLottoCount + Message.USER_LOTTOS_COUNT_MESSAGE);
        List<Lotto> userLottos = lottoService.getUserLottos();

        for (Lotto lotto : userLottos) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    private void createWinningLotto() {
        WinningLotto winningLotto = inputService.inputWinningLottoNumbersAndBonusNumber();
        lottoResultService.setWinningLotto(winningLotto);
    }

}
