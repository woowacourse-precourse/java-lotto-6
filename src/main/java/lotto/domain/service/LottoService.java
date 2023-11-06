package lotto.domain.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoResultManager;
import lotto.domain.LottoResults;
import lotto.domain.LottoStatistics;
import lotto.global.utils.generator.NumbersGenerator;

public class LottoService {

    public LottoResultManager generateLottoNumbers(NumbersGenerator numbersGenerator, long purchaseCount) {
        List<LottoResult> lottoResults = new ArrayList<>();
        for (int index = 0; index < purchaseCount; index++) {
            lottoResults.add(new LottoResult(new Lotto(numbersGenerator.generate())));
        }
        return new LottoResultManager(
                new LottoResults(lottoResults),
                new LottoStatistics(new HashMap<>())
        );
    }
}
