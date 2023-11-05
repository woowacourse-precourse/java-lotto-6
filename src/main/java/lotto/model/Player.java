package lotto.model;

import java.util.List;

public class Player {

    private List<Lotto> lottos;
    private int money;
    private LottoStore lottoStore;

    private Player(int money, LottoStore lottoStore) {
        this.money = money;
        this.lottoStore = lottoStore;
    }

    public static Player of(int money, LottoStore lottoStore) {
        return new Player(money, lottoStore);
    }

    public void buyLotto() {
        this.lottos = lottoStore.sellLotto(this.money);
    }

    public int getEA() {
        return this.lottos.size();
    }

    public List<List<Integer>> getHistory() {
        return lottos.stream()
                .map(Lotto::getNumbers)
                .toList();
    }
}
