package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    InputView inputView;
    OutputView outputView;
    LottoMachine lottoMachine;

    LottoController() {
        inputView = new InputView();
        outputView = new OutputView();
        lottoMachine = new LottoMachine();
    }

    public void start() {
        List<Lotto> tickets = buyLotto();
        showTickets(tickets);
    }

    private List<Lotto> buyLotto() {
        try {
            int money = inputView.inputPurchaseAmount();
            return lottoMachine.buy(money);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return buyLotto();
        }
    }

    private void showTickets(List<Lotto> tickets) {
        List<String> numbers = new ArrayList<>();
        for (Lotto lotto : tickets) {
            numbers.add(lotto.toString());
        }
        outputView.printGeneratedLotto(numbers);
    }
}
