package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.util.RandomNumberGenerator;

public class LottoTicketMachine {
    public static final int LOTTO_PRICE = 1000;
    public static final int MAX_PURCHASE_AMOUNT = 100000;

    public LottoTicket getLottoTicket(int price) {
        int lottoCount = getLottoCount(price);
        List<Lotto> lotto = getLotto(lottoCount);
        return LottoTicket.of(lotto, lotto.size(), price);
    }

    private int getLottoCount(int price) {
        return price / LOTTO_PRICE;
    }

    private Lotto getOneLotto() {
        List<Integer> lottoNumbers = RandomNumberGenerator.pickUniqueRandomNumbersInRange(Lotto.LOTTO_NUMBER_MIN,
                Lotto.LOTTO_NUMBER_MAX, Lotto.LOTTO_NUMBERS_SIZE);
        return new Lotto(lottoNumbers);
    }

    private List<Lotto> getLotto(int count) {
        List<Lotto> lotto = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lotto.add(getOneLotto());
        }
        return lotto;
    }

}
