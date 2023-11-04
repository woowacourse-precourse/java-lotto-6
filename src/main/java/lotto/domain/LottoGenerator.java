package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private RandomSixNumberGenerator randomNumberGenerator;

    public LottoGenerator() {
        this(new RandomSixNumberGenerator());
    }

    public LottoGenerator(RandomSixNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public List<Lotto> generateLottos(int numberOfLotto) {
        List<Lotto> lottos = new ArrayList<>();

        for (int count = 0; count < numberOfLotto; count++) {
            lottos.add(generateLotto());
        }

        return lottos;
    }

    private Lotto generateLotto() {
        List<Integer> sixNumbers = randomNumberGenerator.getSixNumber();

        return new Lotto(sixNumbers);
    }
}
