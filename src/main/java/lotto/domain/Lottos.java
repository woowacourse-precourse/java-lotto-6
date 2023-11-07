package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private static final int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos;

    public Lottos(int input) {
        this.lottos = generateLottos(numberLottos(input));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int numberLottos(int inputPrice) {
        isNotDivided(LOTTO_PRICE, inputPrice);
        return inputPrice / LOTTO_PRICE;
    }

    public List<Lotto> generateLottos(int lottoCount) {
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> new Lotto(NumberGenerator.createRandomNumbers()))
                .collect(Collectors.toList());
    }

    private void isNotDivided(int lottoPrice, int inputPrice) {
        if (inputPrice % lottoPrice != 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }

}
