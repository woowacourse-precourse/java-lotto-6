package lotto;

import lotto.controller.LottoController;
import lotto.controller.LottoResultController;
import lotto.controller.WinningLottoController;
import lotto.view.LottoView;

public class Application {
    public static void main(String[] args) {
        LottoView lottoView = new LottoView();
        LottoController lottoController = new LottoController(lottoView);
        lottoView.printMyLotto(lottoController.getLottos());

        WinningLottoController winningLottoController = new WinningLottoController(lottoView);
        LottoResultController lottoResultController = new LottoResultController(
                winningLottoController.getWinningLotto(),
                lottoController.getLottos()
        );

        lottoView.winningStatistics(lottoResultController.getLottoResult());
    }
}
