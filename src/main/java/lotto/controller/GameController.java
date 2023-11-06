package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.CreateLotto;
import lotto.domain.GameResult;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Profit;
import lotto.domain.WinningNumber;
import lotto.view.OutputView;
import lotto.view.UserInput;

import java.util.List;

public class GameController {
    private final UserInput userInput = new UserInput();
    private final OutputView outputView = new OutputView();
    private final CreateLotto createLotto = new CreateLotto();
    private final GameResult gameResult = new GameResult();
    private final Profit profit = new Profit();
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
        outputView.printLottoNumbers(lottos);

        winningNumbers = userInput.askWinningNumber();
        winningLotto = new Lotto(winningNumbers.getWinningNumbers());

        outputView.printBlankLine();
        bonusNumber = userInput.askBonusNumber();

        for (int i = 0; i < createLotto.getAmount(); i++) {
            hasBonusNumber = gameResult.hasBonusNumber(lottos.get(i), bonusNumber);
            gameResult.setRankingNumbers(winningLotto, lottos.get(i), hasBonusNumber);
        }

        outputView.printGameResult(gameResult);
        profit.setProfit(gameResult);
        profit.setProfitRate(money);
        outputView.printProfitRate(profit.getProfitRate());
    }
}
