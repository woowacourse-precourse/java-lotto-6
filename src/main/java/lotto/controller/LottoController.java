package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.domain.User;
import lotto.service.LottoService;
import lotto.utils.Utills;
import lotto.view.InputView;

public class LottoController {

    private User user;
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        beforeStart();
    }

    private void beforeStart() {
        user = new User(getInputAmount());
        lottoService.buyLottoAll(user);
        // TODO: 로또 구매 후 로또 번호 출력
    }

    private int getInputAmount() {
        InputView.inputAmount();
        String userInput = readLine().trim();
        return Utills.stringToInteger(userInput);
    }
}
