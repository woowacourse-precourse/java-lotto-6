package lotto.controller;

import java.util.List;
import lotto.domain.model.Lotto;
import lotto.domain.model.Lottos;
import lotto.domain.model.GameResult;
import lotto.domain.service.Money;
import lotto.domain.service.User;
import lotto.view.OutputView;

public class GameController {
    private User user;
    private Money money;
    private Lotto answer;
    private int bonusNumber;
    private int ticketAmount;
    private final InputController inputController;
    private final OutputView outputView;

    public GameController(InputController inputController, OutputView outputView ,User user, Money money) {
        this.user = user;
        this.inputController = inputController;
        this.outputView = outputView;
        this.money = money;
    }

    public void startGame() {
        money = buyLottos();
        user = user.newInstance(money);
        Lottos userLottos = generateUserLottos(ticketAmount);
        outputView.showUserLottoMessage(userLottos);
    }

    public Money buyLottos() {
        outputView.showInputMoneyMessage();
        int givenMoney = inputController.getMoney();
        this.money.saveMoney(givenMoney);
        this.ticketAmount = money.getTicketAmount(givenMoney);
        outputView.showLottoAmountMessage(this.ticketAmount);
        return this.money;
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
        this.answer = Lotto.newInstance(answerNumbers);
        outputView.showInputLottoBonusNumberMessage();
        this.bonusNumber = inputController.getBonusNumber();
    }

    private void showWinnerPrice() {
        outputView.showResultHeadMessage();
        GameResult gameResult = user.matchUp(answer, bonusNumber);
        outputView.showBallCountResult(gameResult);
        outputView.showProfit(gameResult);
    }

}
