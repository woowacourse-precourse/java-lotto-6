package lotto.model;

import java.util.List;

public class Buyer {
    private final Money money;
    private final List<Lotto> lottos;

    public Buyer(String inputMoney) {
        this.money = new Money(inputMoney);
        lottos = LottoStore.buyLotto(money);
    }

    public void printLottos() {
        lottos.forEach(lotto -> System.out.println(lotto.getLottoPrintMessage()));
    }

    public int getLottoCount() {
        return lottos.size();
    }
}
