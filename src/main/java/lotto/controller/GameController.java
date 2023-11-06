package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.LottosResult;
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
    public Money buyLottos() {
        outputView.showInputMoneyMessage();
        int givenMoney = inputController.getMoney();
        this.ticketAmount = Money.getTicketAmount(givenMoney);
        outputView.showLottoAmountMessage(this.ticketAmount);
        return new Money(givenMoney);
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
        LottosResult gameResult = user.matchUp(answer, bonusNumber);
        outputView.showBallCountResult(gameResult);
        outputView.showProfit(gameResult);
    }

}
