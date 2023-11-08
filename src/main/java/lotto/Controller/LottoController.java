package lotto.Controller;

import lotto.Domain.Bonus;
import lotto.Domain.Lotties;
import lotto.Domain.Lotto;
import lotto.Domain.LottoResult;
import lotto.Domain.Money;
import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoController {

    private static LottoController lottoController = new LottoController();
    private InputView inputView;
    private OutputView outputView;

    private LottoController() {
        this.inputView = InputView.getInstance();
        this.outputView = OutputView.getInstance();
    }

    public static LottoController getInstance() {
        return lottoController;
    }

    public void run() {
        Money money = getMoney();
        showLottoCount(money.getCount());

        Lotties lotties = new Lotties(money.getCount());
        showLotties(lotties);

        Lotto lotto = getLotto();
        Bonus bonus = getBonus();

        LottoResult lottoResult = new LottoResult();
        lottoResult.calculateLottoResult(lotties, lotto, bonus);
        double rate = lottoResult.getRate(money.getValue());
        showResult(lottoResult, rate);
    }

    private Money getMoney() {
        while (true) {
            try {
                return inputView.inputMoney();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void showLottoCount(int count) {
        outputView.showLottoCount(count);
    }

    private void showLotties(Lotties lotties) {
        outputView.showLotties(lotties);
    }

    private void showResult(LottoResult lottoResult, Double rate) {
        outputView.showLottoResult(lottoResult);
        outputView.showRate(rate);
    }

    private Lotto getLotto() {
        while (true) {
            try {
                return new Lotto(inputView.inputLotto());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Bonus getBonus() {
        while (true) {
            try {
                return inputView.inputBonus();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
