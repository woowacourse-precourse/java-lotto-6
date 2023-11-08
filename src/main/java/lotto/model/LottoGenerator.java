package lotto.model;

import lotto.util.LottoRandomNumbers;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public List<Lotto> generateLottos(int ticket){
        List<Lotto> lottos = new ArrayList<>();

            while (lottos.size() < ticket) {
                lottos.add(generateLotto());
            }
        return lottos;
    }

    public Lotto generateLotto() {
        LottoRandomNumbers lottoRandomNumbers = new LottoRandomNumbers();
        return new Lotto(lottoRandomNumbers.generateLottoNumbers());
    }
}
