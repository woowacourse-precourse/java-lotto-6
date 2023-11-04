package lotto.service;

import java.util.HashSet;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoRule;

public class LottoGeneratorService {

    private final LottoNumberGeneratorService lottoNumberGeneratorService;

    public LottoGeneratorService(LottoNumberGeneratorService lottoNumberGeneratorService) {
        this.lottoNumberGeneratorService = lottoNumberGeneratorService;
    }

    public Lotto generateLotto() {
        Set<LottoNumber> uniqueLottoNumbers = new HashSet<>();
        while (uniqueLottoNumbers.size() < LottoRule.LOTTO_LENGTH.getValue()) {
            uniqueLottoNumbers.add(lottoNumberGeneratorService.generate());
        }
        return Lotto.from(uniqueLottoNumbers.stream().toList());
    }
}
