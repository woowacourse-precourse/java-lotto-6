package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.controller.Controller;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.policy.WinConditionPolicy;

public class Application {
    private static Controller controller = new Controller();
    private static List<WinConditionPolicy> results = new ArrayList<>();

    public static void main(String[] args) {
        int purchaseAmount = controller.getPurchaseAmount();
        User user = controller.createUserLotto(purchaseAmount);
        controller.listPurchaseLotto(user);
        Lotto winLottoNumber = controller.getWinLottoNumber();
        int bonusLottoNumber = controller.getBonusLottoNumber(winLottoNumber);
        setResults(user, winLottoNumber, bonusLottoNumber);
    }

    private static void setResults(User user, Lotto winLottoNumber, int bonusLottoNumber) {
        for (Lotto lotto : user.getLotto()) {
            int winNumberCount = controller.getWinNumberCount(lotto, winLottoNumber);
            int bonusNumberCount = controller.getBonusNumberCount(lotto, bonusLottoNumber);
            controller.makeResults(results, winNumberCount, bonusNumberCount);
        }
    }
}
