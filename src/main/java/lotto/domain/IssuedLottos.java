package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class IssuedLottos {
    private final List<Lotto> issuedLottos;

    public IssuedLottos(long quantity) {
        this.issuedLottos = generateLottoNumbersPurchase(quantity);
    }

    public List<Lotto> getIssuedLottos() {
        return issuedLottos;
    }

    private List<Lotto> generateLottoNumbersPurchase(long quantity) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            lottos.add(generateValidatedLotto());
        }

        return lottos;
    }

    private Lotto generateValidatedLotto() {
        List<Integer> randomNumbers = new LottoGenerator().getRandomNumbers();
        return new Lotto(randomNumbers);
    }

}
