package lotto.model;

import java.util.List;
import lotto.Lotto;

public class Player {

    private final List<Lotto> lotteries;

    private Player(List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }
}
