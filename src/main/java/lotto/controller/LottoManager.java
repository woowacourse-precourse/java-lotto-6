package lotto.controller;
import lotto.model.User;
import lotto.view.UserView;

public class LottoManager {
    private UserView userView;
    private User user;
    public LottoManager() {
        userView = new UserView();
        user = new User();
    }

    public void start() {
        userView.printBuyMessageBefore();
        user.setPurchaseAmount(UserInput.PurchaseAmount());

        user.setPurchaseLottoNumber(UserInput.calculatePurchaseLottoNumber(user.getPurchaseAmount()));
        userView.printBuyMessageAfter(user.getPurchaseLottoNumber());

        user.setLottos();
        userView.printLottos(user.getLottos());

        userView.printInputWinningNumbersMessage();
        UserInput.winningNumbers();

        userView.printInputBonusNumberMessage();
        UserInput.bonusNumber();

        user.calculateWinning();
        userView.printWinningStatistic(user);

        user.calculateEarningRate();
        userView.printEarningRate(user);
    }
}
