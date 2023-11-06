package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class PublishLotto {
    public List<Lotto> LottoNumberGenerate(int lottoNumbersCount) {
        List<Lotto> lottos = new ArrayList<>();

        while (lottos.size() < lottoNumbersCount) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    public Lotto generateLotto() {
        RandomLottoNumber randomLottoNumber = new RandomLottoNumber();
        return new Lotto(randomLottoNumber.RandomLottoOutputNumber());
    }
}
