package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoService(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> buyLottos(int purchaseAmount) {
        int numberOfLottos = purchaseAmount / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(new Lotto(lottoNumberGenerator.generate()));
        }
        return lottos;
    }
}
