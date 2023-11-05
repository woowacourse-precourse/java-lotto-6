package lotto.domain;

import lotto.util.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {

    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoSeller(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> sellLottos(Cash cash) {
        Integer lottoCounts = cash.calculateNumberOfLottos();

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCounts; i++) {
            List<Integer> lottoNumbers = lottoNumberGenerator.generateLottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }
        return lottos;
    }
}
