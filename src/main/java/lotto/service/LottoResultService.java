package lotto.service;

import java.util.List;
import lotto.constant.Rank;
import lotto.domain.Lotto;
import lotto.domain.LottoMatcher;
import lotto.domain.PrizeCalculator;
import lotto.domain.ROICalculator;
import lotto.domain.WinningNumbers;
import lotto.dto.LottoPlayInfo;
import lotto.dto.LottoResult;

public class LottoResultService {
    private final PrizeCalculator prizeCalculator;
    private final ROICalculator roiCalculator;

    public LottoResultService() {
        this.prizeCalculator = new PrizeCalculator();
        this.roiCalculator = new ROICalculator();
    }

    public LottoResult getLottoResult(List<Lotto> lottos, LottoPlayInfo drawnInfo) {
        WinningNumbers winningNumbers = createWinningNumbers(drawnInfo);
        List<Rank> ranks = matchLottos(lottos, winningNumbers);
        return calculateResult(ranks, drawnInfo.investment());
    }

    private WinningNumbers createWinningNumbers(LottoPlayInfo drawnInfo) {
        return new WinningNumbers(drawnInfo.drawnNumbers(), drawnInfo.bonusNumber());
    }

    private List<Rank> matchLottos(List<Lotto> lottos, WinningNumbers winningNumbers) {
        LottoMatcher lottoMatcher = new LottoMatcher(winningNumbers);
        return lottos.stream()
            .map(lottoMatcher::match)
            .toList();
    }

    private LottoResult calculateResult(List<Rank> ranks, int investment) {
        long totalPrize = prizeCalculator.calculatePrize(ranks);
        double roi = roiCalculator.calculate(totalPrize, investment);
        return new LottoResult(ranks, roi);
    }
}
