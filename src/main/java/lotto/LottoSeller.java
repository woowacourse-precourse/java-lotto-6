package lotto;

import java.util.List;
import view.InputView;
import view.OutputView;

public class LottoSeller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoMachine lottoMachine = new LottoMachine();
    private Money money;
    private List<Lotto> createdLotto;

    public void buyLotto() {
        money = receiveMoneyFromPlayer();
        printLottoCount(money);
        createdLotto = getLottos(money);
        printLottos();
    }

    private Money receiveMoneyFromPlayer() {
        while (true) {
            try {
                return new Money(inputView.inputMoney());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printLottoCount(Money money) {
        outputView.printLottoCount(money);
    }

    private List<Lotto> getLottos(Money money) {
        return lottoMachine.createLottos(money.getLottoCount());
    }

    private void printLottos() {
        outputView.printLottos(createdLotto);
    }
}
