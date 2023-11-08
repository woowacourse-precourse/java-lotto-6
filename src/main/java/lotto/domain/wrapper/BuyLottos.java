package lotto.domain.wrapper;

import java.util.List;

public class BuyLottos {

    private final List<Lotto> buyLottos;

    private BuyLottos(List<Lotto> buyLottos) {
        this.buyLottos = buyLottos;
    }

    public static BuyLottos create(List<Lotto> buyLottos) {
        return new BuyLottos(buyLottos);
    }

    public List<Lotto> getBuyLottos() {
        return List.copyOf(buyLottos);
    }
}
