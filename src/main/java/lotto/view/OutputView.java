package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.User;

import java.util.List;

public class OutputView {

    private static final String BUY_LOTTO_AMOUNT_MESSAGE = "개를 구매했습니다.";

    public void printPurchaseLotto(User user) {
        printPurchaseLottoAmount(user.getMoney());
        printLottoNumbers(user.getLottos());
        System.out.println();
    }

    private void printPurchaseLottoAmount(int money) {
        System.out.println(money / 1000 + BUY_LOTTO_AMOUNT_MESSAGE);
    }

    private void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLottoNumbers());
        }
    }
}
