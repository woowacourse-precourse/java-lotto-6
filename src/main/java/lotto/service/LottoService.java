package lotto.service;

import lotto.domain.BonusNumber;
import lotto.domain.LottoPublisher;
import lotto.domain.LottoResult;
import lotto.domain.UserAmount;
import lotto.domain.WinnerRevenue;
import lotto.domain.WinningBundle;
import lotto.domain.WinningTier;
import lotto.dto.LottoPurchaseResultDto;
import lotto.dto.LottoResultDto;
import lotto.dto.RevenueDto;

public class LottoService {

    private LottoPublisher lottoPublisher;

    public LottoPurchaseResultDto purchaseLottos(UserAmount userAmount) {
        int issueAbleCount = userAmount.calculateIssueAbleCount();
        lottoPublisher = new LottoPublisher(issueAbleCount);
        return new LottoPurchaseResultDto(lottoPublisher.getLottos());
    }

    public LottoResultDto evaluateWinnings(LottoPurchaseResultDto purchaseResult, WinningBundle winningBundle, BonusNumber bonusNumber) {
        LottoResult lottoResult = new LottoResult(purchaseResult.getLottos(), winningBundle.getWinningBundle(), bonusNumber.toInt());
        WinningTier winningTier = new WinningTier();

        winningTier.estimate(lottoResult.getCorrectWinningsCount(), lottoResult.getCorrectBonuses());

        return new LottoResultDto(
                winningTier.getWinningTier(),
                lottoResult.getCorrectWinningsCount(),
                lottoResult.getCorrectBonuses()
        );
    }

    public RevenueDto calculateRevenue(UserAmount userAmount, LottoResultDto lottoResult) {
        WinnerRevenue winnerRevenue = new WinnerRevenue(lottoResult.getCorrectWinningsCount(), lottoResult.getCorrectBonuses());
        RevenueDto revenueDto = winnerRevenue.generateRevenueDto(userAmount.getUserAmount());

        return revenueDto;
    }
}
