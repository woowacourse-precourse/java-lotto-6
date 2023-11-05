package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private RandomGenerator randomGenerator;
    private List<Lotto> lottos;
    public LottoGenerator() {
        lottos = new ArrayList<>();
        randomGenerator = new RandomGenerator();
    }

    public void makeLottos(int number) {
        for (int i = 0; i < number; i++) {
            Lotto lotto = createLotto();
            lottos.add(lotto);
        }
    }

    private Lotto createLotto() {
        List<Integer> numbers = randomGenerator.createUniqueNumbers(1, 45, 6);
        return new Lotto(numbers);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
