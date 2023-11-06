package lotto.controller;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.CreateLotto;
import lotto.domain.GameResult;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningNumber;
import lotto.input.UserInput;

public class GameController {
    private final UserInput userInput = new UserInput();
    private final CreateLotto createLotto = new CreateLotto();
    private GameResult gameResult = new GameResult();
    private Money money;
    private List<Lotto> lottos;
    private WinningNumber winningNumbers;
    private Lotto winningLotto;
    private BonusNumber bonusNumber;
    private boolean hasBonusNumber;

    public void start() {
        money = userInput.askMoney();
        createLotto.setAmount(money);
        createLotto.multipleLotto();
        lottos = createLotto.getLottos();

        winningNumbers = userInput.askWinningNumber();
        winningLotto = new Lotto(winningNumbers.getWinningNumbers());
        bonusNumber = userInput.askBonusNumber();

        for (int i = 0; i < createLotto.getAmount(); i++) {
            hasBonusNumber = gameResult.hasBonusNumber(lottos.get(i), bonusNumber);
            gameResult.setRankingNumbers(winningLotto, lottos.get(i), hasBonusNumber);
        }
    }
}
