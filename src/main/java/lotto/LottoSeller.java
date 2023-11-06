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

    public Money receiveMoneyFromPlayer() {
        while (true) {
            try {
                return new Money(inputView.inputMoney());
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
