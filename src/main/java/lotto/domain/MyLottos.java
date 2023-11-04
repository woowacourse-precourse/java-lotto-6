package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyLottos {
    private List<Lotto> lottos;

    public MyLottos() {

    }

    public void responseCreateMyLottos(int lottoNumber){
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
