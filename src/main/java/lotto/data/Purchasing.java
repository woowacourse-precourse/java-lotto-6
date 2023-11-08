package lotto.data;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Purchasing {
    private int purchasedPrice;
    private List<Lotto> lottos;

    public Purchasing(int purchasedPrice) {
        this.purchasedPrice = purchasedPrice;
        this.lottos = generateLottos(purchasedPrice / 1000); // Assuming 1000 is the price of one Lotto
    }

    private List<Lotto> generateLottos(int numberOfLottos) {
        List<Lotto> generatedLottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            generatedLottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return generatedLottos;
    }

    public int getPurchasedPrice() {
        return purchasedPrice;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
