package lotto.model;

import lotto.util.LottoNumberGenerator;
import lotto.util.NumberGenrator;

import java.util.List;

public class Lottos {
    private static final NumberGenrator lottoNumberGenrator = new LottoNumberGenerator();
    private final List<Lotto> lottoNumbers;

    public Lottos(List<Lotto> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }
}
