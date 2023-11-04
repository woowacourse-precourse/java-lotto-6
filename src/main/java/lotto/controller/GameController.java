package lotto.controller;

import java.util.List;
import lotto.model.GameResult;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.User;
import lotto.view.OutputView;

public class GameController {
    private User user;
    private Lotto answer;
    private int bonusNumber;
    private int ticketAmount;
    private final InputController inputController;
    private final OutputView outputView;

    public GameController() {
        this.inputController = new InputController();
        this.outputView = new OutputView();
    }
    public void startGame() {
        user = new User(buyLottos());
        Lottos userLottos = generateUserLottos(ticketAmount);
        outputView.showUserLottoMessage(userLottos);
    }
    public int buyLottos() {
        outputView.showInputMoneyMessage();
        int givenMoney = inputController.getMoney();
        this.ticketAmount = Money.countMoney(givenMoney);
        outputView.showLottoAmountMessage(this.ticketAmount);
        return givenMoney;
    }

    private Lottos generateUserLottos(int ticketAmount) {
        return user.buyLottos(ticketAmount);
    }

    public void showResult() {
        getAnswerNumbers();
        showWinnerPrice();
    }

    private void getAnswerNumbers() {
        outputView.showInputLottoNumberMessage();
        List<Integer> answerNumbers = inputController.getLottoNumber();
        this.answer = new Lotto(answerNumbers);
        outputView.showInputLottoBonusNumberMessage();
        this.bonusNumber = inputController.getBonusNumber();
    }

    private void showWinnerPrice() {
        outputView.showResultHeadMessage();
        GameResult gameResult = user.matchLottos(answer, bonusNumber);
        outputView.showGameResult(gameResult);

    }
}
