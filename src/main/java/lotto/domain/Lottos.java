package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(int lottoQuantity) {
        lottos = generateLottos(lottoQuantity);
    }

    private List<Lotto> generateLottos(int lottoQuantity) {
        RandomLottoNumberGenerator randomLottoNumberGenerator = new RandomLottoNumberGenerator();

        return IntStream.range(0, lottoQuantity)
                .mapToObj(lotto -> new Lotto(randomLottoNumberGenerator.generateRandomNumbers()))
                .collect(Collectors.toList());
    }

    public List<Lotto> getMyLottos() {
        return lottos;
    }
}