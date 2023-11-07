package lotto.model;

import java.util.List;
import java.util.stream.IntStream;

public class LottosGenerator {
    private final RandomNumberGeneratePolicy radomNumbersGeneratePolicy = new RandomNumberGeneratePolicy();

    public Lottos generate(int lottoCount) {
        List<Lotto> generatedLottos = IntStream.range(0, lottoCount)
                .mapToObj(i -> makeLotto())
                .toList();
        return new Lottos(generatedLottos);
    }

    private Lotto makeLotto() {
        List<Integer> generateedRandomNumbers = radomNumbersGeneratePolicy.generate();
        return new Lotto(generateedRandomNumbers);
    }
}
