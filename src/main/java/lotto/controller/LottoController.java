package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.ResultType;
import lotto.service.LottoService;
import lotto.service.ResultService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoController {

    public static InputView inputView = new InputView();
    public static OutputView outputView = new OutputView();
    public static LottoService lottoService = new LottoService();
    public static ResultService resultService = new ResultService();
    public static List<Lotto> lottos = new ArrayList<>();
    public static int amount = 0;
    public void start() {
        try {
            int amount = inputView.inputAmount();
            lottos = lottoService.makeLottoList(amount);
            outputView.printAmount(amount);
            outputView.printLottos(lottos);
            run(amount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void run(int amount) {
        Lotto winningNumber = lottoService.splitString(inputView.inputWinningNumber());
        int bonus = inputView.inputBonusNumber(winningNumber);
        Map<ResultType,Integer> result = resultService.checkLotto(lottos,winningNumber,bonus);
        outputView.printResult(result);
        int prize = resultService.calculatePrize(result);
        outputView.printProfit(resultService.calculateProfit(amount, prize));
    }
}
