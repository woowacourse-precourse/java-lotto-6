package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final List<Lotto> lottos;
    private Money spendMoney;

    public User(Money money) {
        lottos = new ArrayList<>();
        this.spendMoney = money;
        buyLottos();
    }

    private void buyLottos() {
        RandomLottoGenerator lottoGenerator = new RandomLottoGenerator();
        int purchaseLottoCount = spendMoney.getPurchaseLottoCount();
        for (int i = 0; i < purchaseLottoCount; i++) {
            lottos.add(lottoGenerator.generate());
        }
    }


}
