package lotto.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Lotteries {
    List<Lotto> lotteries = new ArrayList<>();

    public Lotteries() {
    }

    public boolean add(Lotto lotto) {
        return this.lotteries.add(lotto);
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }
}
