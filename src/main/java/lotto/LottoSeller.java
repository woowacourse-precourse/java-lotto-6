package lotto;

import java.util.List;
import view.InputView;
import view.OutputView;

public class LottoSeller {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine = new LottoMachine();
    private Money money;
    private List<Lotto> createdLotto;

    public LottoSeller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public Money receiveMoneyFromPlayer() {
        return new Money(inputView.inputMoney());
    }
}
