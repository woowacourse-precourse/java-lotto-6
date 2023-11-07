package lotto.Controller;

import java.util.ArrayList;
import java.util.List;
import lotto.Domain.Bonus;
import lotto.Domain.Lotto;
import lotto.Domain.LottoGenerator;
import lotto.Domain.Money;
import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoController {

    private static LottoController lottoController = new LottoController();
    private InputView inputView;
    private OutputView outputView;
    private List<Lotto> lotties;

    private LottoController() {
        this.inputView = InputView.getInstance();
        this.outputView = OutputView.getInstance();
        this.lotties = new ArrayList<>();
    }

    public static LottoController getInstance() {
        return lottoController;
    }

    public void run() {
        Money money = getMoney();
        showLottoCount(money.getCount());

        lotties = buyLotto(money.getCount());
        showLotties(lotties);

        Lotto lotto = getLotto();
        Bonus bonus = getBonus();
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

    private void showLotties(List<Lotto> lotties) {
        outputView.showLotties(lotties);
    }

    private List<Lotto> buyLotto(int count) {
        return LottoGenerator.makeLotties(count);
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
