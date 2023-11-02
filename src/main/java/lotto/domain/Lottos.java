package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(int money) {
        this.lottos = buyLottos(money);
    }

    private List<Lotto> buyLottos(int money) {
        int count = money / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            RandomLottoNumberGenerator lottoGenerator = new RandomLottoNumberGenerator();
            List<Integer> numbers = lottoGenerator.generateNumbers();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto.makeLotto());
        }
    }
}
