package lotto;

import config.LottoConfig;
import number_generator.NumberGenerator;
import number_generator.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private final NumberGenerator ng;

    public LottoStore() {
        this.ng = new RandomNumberGenerator();
    }

    public LottoStore(NumberGenerator ng) {
        this.ng = ng;
    }

    public List<Lotto> purchaseLottoTickets(int amount) throws IllegalArgumentException {
        int lottoCount = getLottoCount(amount);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(purchaseLottoTicket());
        }
        return lottos;
    }

    private Lotto purchaseLottoTicket() {
        return new Lotto(ng.generateNumberSet(LottoConfig.LOTTO_MIN, LottoConfig.LOTTO_MAX, LottoConfig.LOTTO_SIZE));
    }

    private int getLottoCount(int amount) {
        validateAmount(amount);

        return amount / LottoConfig.LOTTO_PRICE;
    }

    private void validateAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 양수여야 합니다.");
        }
        if (amount % LottoConfig.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(String.format("[ERROR] 로또 구매 금액은 %d원 단위여야 합니다.", LottoConfig.LOTTO_PRICE));
        }
    }
}
