package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private static final int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int numberLottos(String inputPrice) {
        isNotDivided(LOTTO_PRICE, inputPrice);
        return Integer.parseInt(inputPrice) / LOTTO_PRICE;
    }

    public List<Lotto> generateLottos(int lottoCount) {
        NumberGenerator numberGenerator = new NumberGenerator();

        return IntStream.range(0, lottoCount)
                .mapToObj(i -> new Lotto(numberGenerator.createRandomNumbers()))
                .collect(Collectors.toList());
    }

    private void isNotDivided(int lottoPrice, String inputPrice) {
        if (Integer.parseInt(inputPrice) % lottoPrice != 0) {
            throw new IllegalArgumentException();
        }
    }
}
