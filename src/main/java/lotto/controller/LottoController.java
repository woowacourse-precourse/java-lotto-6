package lotto.controller;

import java.util.List;
import lotto.Lotto;
import lotto.service.LottoService;
import lotto.view.Input;
import lotto.view.Print;

public class LottoController {

    private Input input = new Input();
    private Print print = new Print();
    private LottoService lottoService = new LottoService();

    static int cash;
    static List<Lotto> lottos;
    static Lotto winningLotto;
    static int bonusNumber;
    static double profit;
    static int[] result;

    public void LottoSetting() {
        cash = input.cash();
        int lottoAmount = lottoService.calcAmount(cash);

        lottos = lottoService.makeLottos(lottoAmount);
        print.lottos(lottos);

        winningLotto = input.winningNumbers();
        bonusNumber = input.bonusNumber(winningLotto);
        compareLotto();
    }

    public void compareLotto() {
        result = lottoService.compare(lottos, winningLotto, bonusNumber);
        profit = lottoService.calcProfit(result, cash);
        printResult();
    }

    public void printResult() {
        print.result(result);
        print.profit(profit);
    }

}
