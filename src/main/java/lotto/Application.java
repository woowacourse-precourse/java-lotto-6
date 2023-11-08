package lotto;

import java.util.List;
import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController();
        LottoLover lottoLover = new LottoLover();

        lottoController.giveMoneyTo(lottoLover);
        lottoController.brag(lottoLover);

        DrawResult drawResult = lottoController.getDrawResult();
        lottoController.showResult(lottoLover, drawResult);
    }
}
