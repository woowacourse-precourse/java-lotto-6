package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {

    private static final String PURCHASED_LOTTO_MESSAGE = "%d개를 구매했습니다.";

    public void printPurchasedLotto(List<Lotto> userPurchasedLotto) {

        System.out.println(PURCHASED_LOTTO_MESSAGE.formatted(userPurchasedLotto.size()));

        userPurchasedLotto
                .forEach(Lotto::printLottoDetail);

    }
}
