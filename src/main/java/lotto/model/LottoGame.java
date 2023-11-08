package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {
    private final RandomLottoGenerator randomLottoGenerator;
    private final int numberOfLottos;

    public LottoGame(int numberOfLottos) {
        this(numberOfLottos, new RandomLottoGenerator());
    }

    public LottoGame(int numberOfLottos, RandomLottoGenerator randomLottoGenerator) {
        this.randomLottoGenerator = randomLottoGenerator;
        this.numberOfLottos = numberOfLottos;
    }

    public List<Lotto> generateLottos() {
        return IntStream.range(0, numberOfLottos)
                .mapToObj(i -> (randomLottoGenerator.generateLotto()))
                .collect(Collectors.toList());
    }


}
