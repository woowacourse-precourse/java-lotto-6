package lotto.domain;

import java.util.List;

public class LottoStore {

    public static final int LOTTO_PRICE = 1000;
    private final Money money;
    private int lottoQuantity = 0;

    public LottoStore(Money money) {
        this.money = money;
    }

    public int getLottoQuantity(Money money) {
        lottoQuantity = money.getMoney() / 1000;
        return lottoQuantity;
    }

    public List<Lotto> generateLotto() {
        return RandomLottoGenerator.issueRandomLottos(lottoQuantity);
    }
}