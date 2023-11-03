package lotto.domain.lottoresult;

import java.util.Map;

public class LottoResultsRepository {
    private final Map<LottoResult, Integer> lottoResultsRepository;

    public LottoResultsRepository() {
        lottoResultsRepository = LottoResult.getInitialLottoResultsRepository();
    }

    public void saveLottoResult(LottoResult lottoResult) {
        Integer result = lottoResultsRepository.get(lottoResult);
        lottoResultsRepository.put(lottoResult, result + 1);
    }
}
