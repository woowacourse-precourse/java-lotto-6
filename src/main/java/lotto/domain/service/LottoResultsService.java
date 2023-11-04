package lotto.domain.service;

import java.util.List;
import lotto.domain.dto.LottoResultsDto;
import lotto.domain.lotto.WinLotto;
import lotto.domain.lottoresult.LottoResult;
import lotto.domain.lottoresult.LottoResultsRepository;

public class LottoResultsService {

    private final LottoResultsRepository lottoResultsRepository;

    public LottoResultsService(LottoResultsRepository lottoResultsRepository) {
        this.lottoResultsRepository = lottoResultsRepository;
    }

    public void updateLottoResultRepository(LottoPurchaseService lottoPurchaseService, WinLotto winLotto) {
        List<LottoResult> lottoResults = lottoPurchaseService.lottoResult(winLotto);
        lottoResultsRepository.saveLottoResults(lottoResults);
    }

    public LottoResultsDto makeLottoResultsDto() {
        return lottoResultsRepository.makeLottoResultsDto();
    }
}
