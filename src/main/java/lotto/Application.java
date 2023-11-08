package lotto;

import lotto.global.Global;
import lotto.user.User;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        startLotto();
    }

    private static void startLotto() {
        User user = new User();
        Global global = new Global();

        int lottoPurchaseMoney = user.purchaseLotto();
        global.issueLottos(lottoPurchaseMoney);
        List<Integer> winningNumbersAndBonus = new ArrayList<>(
                user.getWinningNumbersAndBonus()
        );
        global.getLottoRanking(winningNumbersAndBonus);
        global.getRateOfReturn(lottoPurchaseMoney);
    }
}
