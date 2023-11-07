package lotto.service;

import lotto.domain.BonusNumber;
import lotto.domain.LottoPublisher;
import lotto.domain.LottoResult;
import lotto.domain.UserAmount;
import lotto.domain.WinnerRevenue;
import lotto.domain.WinningBundle;
import lotto.domain.WinningTier;
import lotto.dto.PurchaseLottoDto;
import lotto.dto.LottoResultDto;
import lotto.dto.RevenueDto;

import java.util.List;

public class LottoService {

    private LottoPublisher lottoPublisher;

    public PurchaseLottoDto purchaseLottos(UserAmount userAmount) {
        int issueAbleCount = userAmount.calculateIssueAbleCount();
        lottoPublisher = new LottoPublisher(issueAbleCount);
        return new PurchaseLottoDto(lottoPublisher.getLottos());
    }

    public LottoResultDto evaluateWinnings(PurchaseLottoDto purchaseLotto, WinningBundle bundle, BonusNumber bonus) {
        List<List<Integer>> lottos = purchaseLotto.getLottos();
        List<Integer> winningBundle = bundle.getWinningBundle();

        LottoResult lottoResult = new LottoResult(lottos, winningBundle, bonus.toInt());
        WinningTier winningTier = new WinningTier();
        winningTier.estimate(lottoResult.toLongList(), lottoResult.toBoolList());

        return new LottoResultDto(winningTier.toHashMap(),
                lottoResult.toLongList(),
                lottoResult.toBoolList()
        );
    }

    public RevenueDto calculateRevenue(UserAmount userAmount, LottoResultDto lottoResult) {
        List<Long> correctWinningsCount = lottoResult.getCorrectWinningsCount();
        List<Boolean> correctBonuses = lottoResult.getCorrectBonuses();

        WinnerRevenue winnerRevenue = new WinnerRevenue(correctWinningsCount, correctBonuses);
        RevenueDto revenueDto = winnerRevenue.generateRevenueDto(userAmount.getUserAmount());

        return revenueDto;
    }
}
