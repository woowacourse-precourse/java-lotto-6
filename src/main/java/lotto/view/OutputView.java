package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.User;

import java.util.List;

public class OutputView {

    private static final String BUY_LOTTO_AMOUNT_MESSAGE = "개를 구매했습니다.";

    public void printPurchaseLotto(User user) {
        printPurchaseLottoAmount(user.getMoney());
        printLottoNumbers(user.getLottoNumbers());
        System.out.println();
    }

    private void printPurchaseLottoAmount(int money) {
        System.out.println(money / 1000 + BUY_LOTTO_AMOUNT_MESSAGE);
    }

    private void printLottoNumbers(List<Lottos> lottos) {
        for (Lottos lotto : lottos) {
            System.out.println(lotto.purchaseLottoNumber());
        }
    }
}
