package lotto.service;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.exception.IllegalMoneyAmountException;
import lotto.service.generator.LottoGenerator;

public class PurchaseService {
    private final int LOTTO_PRICE = 1_000;
    private final LottoGenerator lottoGenerator;

    public PurchaseService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> purchaseLotto(int money) {
        int lottoAmount = calculateLottoAmount(money);
        return IntStream.rangeClosed(1, lottoAmount)
                .mapToObj(i -> generateLotto())
                .toList();
    }

    private Lotto generateLotto() {
        return new Lotto(lottoGenerator.generate());
    }

    private int calculateLottoAmount(int money) {
        validateMoneyDivisibleByPrice(money);
        return money / LOTTO_PRICE;
    }

    private void validateMoneyDivisibleByPrice(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalMoneyAmountException();
        }
    }
}
