package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.domain.PurchasedLotto;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";

    private OutputView() {
    }

    public static void printErrorMessage(final Exception e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
    }

    public static void printBuyQuantity(final PurchasedLotto purchasedLotto) {
        System.out.println(purchasedLotto.getBuyQuantity() + "개를 구매했습니다.");
    }

    public static void printBuyLotto(LottoBundle lottoBundle) {
        List<Lotto> lottos = lottoBundle.getLottos();
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public static void printNewLine() {
        System.out.println();
    }
}
