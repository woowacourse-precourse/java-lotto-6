package lotto;

import lotto.controller.Controller;
import lotto.model.Lotto;
import lotto.model.User;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();
        int purchaseAmount = controller.getPurchaseAmount();
        User user = controller.createUserLotto(purchaseAmount);
        controller.listPurchaseLotto(user);
        Lotto winLottoNumber = controller.getWinLottoNumber();
        int bonusLottoNumber = controller.getBonusLottoNumber(winLottoNumber);
    }
}
