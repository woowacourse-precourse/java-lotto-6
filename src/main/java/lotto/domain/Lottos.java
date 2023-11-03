package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public String getPurchaseDetails() {
        StringBuilder purchasedLottos = new StringBuilder();

        for (Lotto lotto : lottos) {
            purchasedLottos.append(lotto.getNumbers()).append("\n");
        }

        return purchasedLottos.toString();
    }
}
