package lotto.domain.lottoresult;

import static lotto.domain.lottoresult.LottoPrizeMoney.makeZeroLottoPrizeMoney;

import java.util.Map;
import lotto.domain.dto.LottoResultsDto;

public class LottoResultsRepository {
    private final Map<LottoResult, Integer> lottoResultsRepository;
    private LottoPrizeMoney lottoPrizeMoney;

    public LottoResultsRepository() {
        lottoResultsRepository = LottoResult.getInitialLottoResultsRepository();
        lottoPrizeMoney = makeZeroLottoPrizeMoney();
    }

    public void saveLottoResult(LottoResult lottoResult) {
        if (lottoResult.isNone()) {
            return;
        }
        Integer numberOfResult = lottoResultsRepository.get(lottoResult);
        lottoResultsRepository.put(lottoResult, numberOfResult + 1);
        lottoPrizeMoney = lottoPrizeMoney.updateLottoPrizeMoney(lottoResult);
    }

    public LottoResultsDto makeLottoResultsDto() {
        return new LottoResultsDto(lottoResultsRepository);
    }

    public long getTotalLottoPrizeMoney() {
        return lottoPrizeMoney.getLottoPrizeMoney();
    }
}
