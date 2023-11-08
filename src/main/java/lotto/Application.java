package lotto;

import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoService lottoService = new LottoService();
        LottoController lottoController = new LottoController(lottoService, inputView, outputView);
        List<Lotto> lottos = lottoController.getLotto();
        lottoController.printLotto(lottos);
        List<Integer> winNumbers = lottoController.getWinNumber();
        int bonusNumber = lottoController.getBonusNumber(winNumbers);
        lottoController.compareLottoNumbers(lottos, winNumbers, bonusNumber);
    }
}
