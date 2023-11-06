package lotto.controller;

import java.util.List;
import lotto.domain.CreateLottoByAmount;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningNumber;
import lotto.input.UserInput;

public class GameController {
    private final CreateLottoByAmount createLottoByAmount = new CreateLottoByAmount();
    private final UserInput userInput = new UserInput();

    public void start() {
        Money money = userInput.askMoney();
        createLottoByAmount.setAmount(money);
        createLottoByAmount.multipleLotto();
        List<Lotto> lottos = createLottoByAmount.getLottos();
        WinningNumber winningNumbers = userInput.askWinningNumber();
        Lotto winningLotto = new Lotto(winningNumbers.getWinningNumbers());
    }
}
