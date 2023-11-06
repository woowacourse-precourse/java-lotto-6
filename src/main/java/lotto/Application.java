package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.controller.Controller;
import lotto.model.Lotto;
import lotto.model.Result;
import lotto.model.User;
import lotto.policy.WinConditionPolicy;

public class Application {
    private static Controller controller = new Controller();
    private static List<WinConditionPolicy> winResult = new ArrayList<>();

    public static void main(String[] args) {
        int purchaseAmount = controller.getPurchaseAmount();
        User user = controller.createUserLotto(purchaseAmount);
        controller.listPurchaseLotto(user);
        Lotto winLottoNumber = controller.getWinLottoNumber();
        int bonusLottoNumber = controller.getBonusLottoNumber(winLottoNumber);
        setWinResult(user, winLottoNumber, bonusLottoNumber);
        Result result = Result.of(winResult);
        controller.showWinStatistics(result);
    }

    private static void setWinResult(User user, Lotto winLottoNumber, int bonusLottoNumber) {
        for (Lotto lotto : user.getLotto()) {
            int winNumberCount = controller.getWinNumberCount(lotto, winLottoNumber);
            int bonusNumberCount = controller.getBonusNumberCount(lotto, bonusLottoNumber);
            controller.makeResults(winResult, winNumberCount, bonusNumberCount);
        }
    }
}
