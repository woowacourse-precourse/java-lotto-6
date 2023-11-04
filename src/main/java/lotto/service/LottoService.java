package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.random.RandomNumberGenerator;

import java.util.List;

public class LottoService {
    private final RandomNumberGenerator randomNumberGenerator;

    private List<Lotto> lottos;
    private WinningLotto winningLotto;

    public LottoService(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }
}