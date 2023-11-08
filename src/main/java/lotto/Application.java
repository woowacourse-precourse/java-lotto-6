package lotto;

import lotto.controller.LottoGameController;
import lotto.util.GenerateRandomLottoNumbers;
import lotto.util.RandomUtils;

public class Application {
    public static void main(String[] args) {
        LottoGameController lottoGameController = new LottoGameController();
        lottoGameController.startGame();
    }
}
