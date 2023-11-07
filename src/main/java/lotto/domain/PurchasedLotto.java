package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLotto {
    private final List<Lotto> purchasedLotto;
    public PurchasedLotto(int numberOfPurchase) {
        this.purchasedLotto = generateLottoNumbers(numberOfPurchase);
    }
    public List<Lotto> getPurchasedLottos() {
        return  purchasedLotto;
    }

    private List<Lotto> generateLottoNumbers(int number) {
        List<Lotto> lottos = new ArrayList<>();

        for(int i =0; i < number; i++) {
            lottos.add(generateValidatedLotto());
        }
        return lottos;
    }

    private Lotto generateValidatedLotto() {
        return new Lotto(new LottoMachine().getRandomNumbers());
    }
}
