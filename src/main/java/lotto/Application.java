package lotto;

import lotto.controller.LottoMainController;

public class Application {
    public static void main(String[] args) {
        LottoMainController lottoMainController = new LottoMainController();
        lottoMainController.play();
    }
}
