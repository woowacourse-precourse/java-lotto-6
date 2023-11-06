package lotto.controller;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.CreateLottoByAmount;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningNumber;
import lotto.input.UserInput;

public class GameController {
    private final UserInput userInput = new UserInput();
    private final CreateLottoByAmount createLottoByAmount = new CreateLottoByAmount();
    private Money money;
    private List<Lotto> lottos;
    private WinningNumber winningNumbers;
    private Lotto winningLotto;
    private BonusNumber bonusNumber;

    public void start() {
        money = userInput.askMoney();
        createLottoByAmount.setAmount(money);
        createLottoByAmount.multipleLotto();
        lottos = createLottoByAmount.getLottos();

        winningNumbers = userInput.askWinningNumber();
        winningLotto = new Lotto(winningNumbers.getWinningNumbers());
        bonusNumber = userInput.askBonusNumber();


    }
}
