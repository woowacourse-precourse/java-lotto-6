package lotto.domain.service;

import java.util.List;
import lotto.domain.dto.LottoBundleDto;
import lotto.domain.dto.LottoResultsDto;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinLotto;
import lotto.domain.lottoresult.LottoResult;
import lotto.domain.lottoresult.LottoResultsRepository;
import lotto.domain.player.Player;
import lotto.domain.player.Profit;

public class LottoResultsService {

    private final LottoResultsRepository lottoResultsRepository;

    public LottoResultsService(LottoResultsRepository lottoResultsRepository) {
        this.lottoResultsRepository = lottoResultsRepository;
    }

    public void updateLottoResultRepository(LottoBundleDto lottoBundleDto, WinLotto winLotto) {
        List<Lotto> lottoBundleData = lottoBundleDto.getLottoBundleData();
        for (Lotto lottoBundleDatum : lottoBundleData) {
            LottoResult lottoResult = winLotto.getLottoResult(lottoBundleDatum);
            lottoResultsRepository.saveLottoResult(lottoResult);
        }
    }

    public LottoResultsDto makeLottoResultsDto() {
        return lottoResultsRepository.makeLottoResultsDto();
    }

    public Profit calculateProfit(Player player) {
        return player.getProfit(lottoResultsRepository);
    }
}
