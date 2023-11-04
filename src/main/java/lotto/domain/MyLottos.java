package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyLottos {
    private List<Lotto> lottos;

    public MyLottos(int lottoNumber) {
        this.lottos = IntStream.range(0, lottoNumber)
                .mapToObj(i -> Lotto.createLotto())
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }


}
