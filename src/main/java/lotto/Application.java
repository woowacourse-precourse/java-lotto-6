package lotto;

import lotto.Lotto.controller.LottoController;
import lotto.LottoPlayer.controller.LottoPlayerController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController();
        LottoPlayerController playerController = new LottoPlayerController();

        playerController.buyLotto();
        lottoController.setWinningNumbers();
        playerController.extractStatistics();
    }
}
