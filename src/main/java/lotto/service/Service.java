package lotto.service;

import java.util.List;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.util.Util;

public class Service {
    private static final int LOTTO_FIRST_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static final int PURCHASE_AMOUNT_UNIT = 1000;

    private Service() {
    }

    public static void buyLotteries(Buyer buyer) {
        int count = buyer.getPurchaseAmount() / PURCHASE_AMOUNT_UNIT;
        for (int i = 0; i < count; i++) {
            buyOneLotto(buyer);
        }
    }

    private static void buyOneLotto(Buyer buyer) {
        Lotto lotto = createLottoNumber();
        buyer.buyLotto(lotto);
    }

    private static Lotto createLottoNumber() {
        List<Integer> numbers = Util.sortListAscending(Util.createRandomNumberList(Service.LOTTO_FIRST_NUMBER,
                Service.LOTTO_LAST_NUMBER, Service.LOTTO_SIZE));
        return new Lotto(numbers);
    }
}
