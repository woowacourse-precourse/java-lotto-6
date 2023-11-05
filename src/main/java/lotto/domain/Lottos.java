package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;
    private final LottoNumberGenerator lottoNumberGenerator;

    public Lottos(LottoNumberGenerator lottoNumberGenerator, int numberOfLottos) {
        this.lottoNumberGenerator = lottoNumberGenerator;
        this.lottos = create(numberOfLottos);
    }

    public List<Lotto> getLottos(){
        return lottos;
    }
    private List<Lotto> create(int numberOfLottos) {
        List<Lotto> lottoBundle = new ArrayList<>();
        for (int count = 0; count < numberOfLottos; count++) {
            Lotto lotto = generateNumber();
            lottoBundle.add(lotto);
        }
        return lottoBundle;
    }
    private Lotto generateNumber() {
        List<Integer> numbers = lottoNumberGenerator.generateNumbers();
        return new Lotto(numbers);
    }
}
