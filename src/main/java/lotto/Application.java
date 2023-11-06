package lotto;

import lotto.controller.LottoGameController;
import lotto.model.Lotto;
import lotto.model.LottoRankResult;
import lotto.service.LottoGameService;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        ConsoleInputView inputView = new ConsoleInputView();
        ConsoleOutputView outputView = new ConsoleOutputView();
        LottoRankResult result = new LottoRankResult();
        LottoGameService service = new LottoGameService(inputView, outputView, result);
        LottoGameController lottoGameController = new LottoGameController(inputView, outputView, service);
        lottoGameController.run();
    }
}
