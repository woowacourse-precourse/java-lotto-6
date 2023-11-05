package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(LottoQuantity lottoQuantity) {
        lottos = generateLottos(lottoQuantity);
    }

    private List<Lotto> generateLottos(LottoQuantity lottoQuantity) {
        RandomLottoNumberGenerator randomLottoNumberGenerator = new RandomLottoNumberGenerator();
        List<Lotto> newLottos = new ArrayList<>();
        while (lottoQuantity.decreaseOneByOne()) {
            Lotto lotto = new Lotto(randomLottoNumberGenerator.generateRandomNumbers());
            newLottos.add(lotto);
        }
        return newLottos;
    }

    public List<Lotto> getMyLottos() {
        return lottos;
    }
}