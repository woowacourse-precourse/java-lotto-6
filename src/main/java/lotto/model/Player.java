package lotto.model;

import java.util.List;

public class Player {

    private List<Lotto> lottos;
    private Money money;
    private LottoStore lottoStore;

    private Player(Money money, LottoStore lottoStore) {
        this.money = money;
        this.lottoStore = lottoStore;
    }

    public static Player of(Money money, LottoStore lottoStore) {
        return new Player(money, lottoStore);
    }

    public void buyLotto() {
        lottos = lottoStore.sellLotto(money);
    }

    public int getEA() {
        return lottos.size();
    }

    public List<List<Integer>> getHistory() {
        return lottos.stream()
                .map(Lotto::getNumbers)
                .toList();
    }
}
