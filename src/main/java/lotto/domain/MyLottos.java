package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyLottos {
    public List<Lotto> lottos;

    public MyLottos(int lottoNumber) {
        this.lottos = createMyLottos(lottoNumber);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Lotto> createMyLottos(int lottoNumber) {
        return IntStream.range(0, lottoNumber)
                .mapToObj(i -> Lotto.createLotto())
                .collect(Collectors.toList());
    }
}
