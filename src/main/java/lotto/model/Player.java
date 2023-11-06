package lotto.model;

import java.util.List;

public class Player {

    private List<Lotto> lottos;
    private Money money;

    private Player(Money money) {
        this.money = money;
    }

    public static Player of(Money money) {
        return new Player(money);
    }

    public void buyLotto(LottoStore lottoStore) {
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
