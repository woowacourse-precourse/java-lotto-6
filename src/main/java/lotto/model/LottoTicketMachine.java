package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.LottoPurchase;
import lotto.util.RandomNumberGenerator;

public class LottoTicketMachine {

    public LottoTicket getLottoTicket(LottoPurchase lottoPurchase) {
        int purchaseMoney = lottoPurchase.getMoney();
        int lottoCount = getLottoCount(purchaseMoney);
        List<Lotto> lotto = getLotto(lottoCount);
        return LottoTicket.of(lotto, lotto.size(), purchaseMoney);
    }

    private int getLottoCount(int price) {
        return price / LottoPurchase.LOTTO_PRICE;
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
