package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public int getLottosSize() {
        return lottos.size();
    }

    public List<String> printNumbers(int purchaseCount) {
        List<String> purchasedNumbers = new ArrayList<>();

        for (int i = 0; i < purchaseCount; i++) {
            purchasedNumbers.add(lottos.get(i).toString());
        }

        return purchasedNumbers;
    }

    public Lotto getLotto(int index) {
        return lottos.get(index);
    }
}
