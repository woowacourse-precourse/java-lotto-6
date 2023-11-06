package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public static InputView inputView = new InputView();
    public static OutputView outputView = new OutputView();
    public static LottoService lottoService = new LottoService();
    public static List<Lotto> lottos = new ArrayList<>();

    public void start() {
        int amount = inputView.inputAmount();
        lottos = lottoService.makeLottoList(amount);
        outputView.printAmount(amount);
        outputView.printLottos(lottos);
        run();
    }
    public void run() {
        String winningNumber = inputView.inputWinningNumber();
    }
}
