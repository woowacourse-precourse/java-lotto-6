package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class PurchaseLotto {
    private final List<Lotto> purchaseLottos;

    public PurchaseLotto(int countOfPurchase) {
        this.purchaseLottos = generateLottoNumbersPurchase(countOfPurchase);
    }

    public List<Lotto> getPurchaseLottos(){
        return purchaseLottos;
    }

    private List<Lotto> generateLottoNumbersPurchase(int countOfPurchase) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < countOfPurchase; i++) {
            lottos.add(generateValidatedLotto());
        }

        return lottos;
    }

    private Lotto generateValidatedLotto() {
        return new Lotto(new LottoMachine().getRandomNumbers());
    }
}
