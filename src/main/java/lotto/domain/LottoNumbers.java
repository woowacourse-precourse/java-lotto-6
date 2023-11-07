package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    private List<Lotto> lottoNumbers = new ArrayList<>();

    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    public List<Lotto> getLottoNumbers(int lottoCnt) {
        for (int i=0; i<lottoCnt; i++) {
            lottoNumbers.add(lottoNumberGenerator.generateLotto());
        }
        return this.lottoNumbers;
    }
}
