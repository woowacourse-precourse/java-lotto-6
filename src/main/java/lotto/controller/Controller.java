package lotto.controller;

import lotto.constants.Message;
import lotto.domain.Lotto;
import lotto.service.InputService;
import lotto.service.LottoService;

import java.util.List;


public class Controller {

    InputService inputService = new InputService();
    LottoService lottoService = new LottoService();

    public void run() {
        createUserLottos();
        showUserLottos();
        createWinningLotto();
        showResult();
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
        List<Integer> winningLottoNumbers = inputService.inputWinningLottoNumbers();
        int bonusNumber = inputService.inputBonusNumber();

        lottoService.setWinningLotto(winningLottoNumbers, bonusNumber);
    }

    private void showResult() {
        System.out.println(Message.LOTTO_RESULT_MESSAGE);

    }

}
