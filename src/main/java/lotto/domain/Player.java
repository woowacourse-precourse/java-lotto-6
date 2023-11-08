package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<Lotto> lottos;
    private final int purchaseAmount;

    public Player(int purchaseAmount) {
        this.lottos = new ArrayList<>();
        this.purchaseAmount = purchaseAmount;
    }
}
