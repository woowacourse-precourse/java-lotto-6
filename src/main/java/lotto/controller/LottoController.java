package lotto.controller;

import java.util.List;
import lotto.domain.PlayerLottoAmount;
import lotto.view.InputView;

public class LottoController {

    private static PlayerLottoAmount playerLottoAmount;

    public void run() {
        try {
            start();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        int ticketCount = inputPlayerAmount();

        String playCount = InputView.inputPlayerPrice();
        new PlayerLottoAmount(playCount);

        List<Integer> list = InputView.inputLottoNumber();
    }

    private int inputPlayerAmount() {
        playerLottoAmount = new PlayerLottoAmount(InputView.inputPlayerPrice());
        return playerLottoAmount.calculateLottoCount();
    }
}
