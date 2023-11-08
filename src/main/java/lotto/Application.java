package lotto;

import lotto.controller.LottoController;
import lotto.controller.RankingController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = LottoController.getInstance();
        RankingController receiptController = RankingController.getInstance();

        lottoController.generateLottos();
        receiptController.rankLottos();
    }
}
