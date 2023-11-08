package lotto.domain.lottoresult;

import static lotto.domain.lottoresult.LottoPrizeMoney.makeZeroLottoPrizeMoney;

import java.util.List;
import java.util.Map;
import lotto.domain.dto.LottoBundleDto;
import lotto.domain.dto.LottoResultsDto;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinLotto;
import lotto.domain.player.Player;
import lotto.domain.player.Profit;

public class LottoResultsRepository {
    private final Map<LottoResult, Integer> lottoResultsRepository;
    private LottoPrizeMoney lottoPrizeMoney;

    public LottoResultsRepository() {
        lottoResultsRepository = LottoResult.getInitialLottoResultsRepository();
        lottoPrizeMoney = makeZeroLottoPrizeMoney();
    }

    public void updateLottoResultRepository(LottoBundleDto lottoBundleDto, WinLotto winLotto) {
        List<Lotto> lottoBundleData = lottoBundleDto.getLottoBundleData();
        for (Lotto lottoData : lottoBundleData) {
            LottoResult lottoResult = winLotto.getLottoResult(lottoData);
            saveLottoResult(lottoResult);
        }
    }

    void saveLottoResult(LottoResult lottoResult) {
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

    public Profit calculateProfit(Player player) {
        return player.getProfit(lottoPrizeMoney);
    }
}
