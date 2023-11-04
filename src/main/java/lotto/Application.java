package lotto;

import lotto.controller.LottoController;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.view.output.LottoBuyOutputView;
import lotto.view.output.LottoResultOutputView;

import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController(new LottoBuyOutputView(), new LottoResultOutputView());
        Lottos lottos = lottoController.buyLottos();
        lottoController.printBuyLottos(lottos);
        Lotto winningLotto = lottoController.requestWinningLotto();
        int bonusNumber = lottoController.requestBonusLottoNumber(winningLotto);
        lottoController.printResult(lottos, winningLotto, bonusNumber);
    }
}
