package lotto;

import lotto.controller.LottoController;
import lotto.view.InputCoin;

public class Application {
    public static void main(String[] args) {
        try {
            LottoController lottoController = new LottoController();
            lottoController.startLottoRoulette();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
