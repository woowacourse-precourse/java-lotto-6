package lotto.domain;
import java.util.List;

public class User {
    private final int purchaseCount;
    private final List<Lotto> lottos;

    public User(int purchaseCount, List<Lotto> lottos) {
        this.purchaseCount = purchaseCount;
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public int getPurchaseCount() {
        return this.purchaseCount;
    }

}
