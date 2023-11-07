package lotto.service;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import lotto.domain.BonusNumber;
import lotto.domain.DrawingResults;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.domain.dto.DrawingResultDto;
import lotto.domain.dto.LottosDto;
import lotto.domain.dto.ProfitRateDto;

public class LottoMachine {

    public Lottos issuedLottos(final PurchaseAmount purchaseAmount) {
        return new Lottos(purchaseAmount);
    }


    public DrawingResults draw(final Lottos lottos, final WinningLotto winningLotto,
                               final BonusNumber bonusNumber) {
        List<Lotto> lottosContents = lottos.getLottos();

        DrawingResults drawingResults = new DrawingResults();

        for (Lotto lotto : lottosContents) {
            int matchedWinningLottoCount = lotto.matchWinningLottoCount(winningLotto);
            boolean hasBonusNumber = lotto.hasBonusNumber(bonusNumber);

            Rank calculateResult = Rank.calculate(matchedWinningLottoCount, hasBonusNumber);
            drawingResults.count(calculateResult);
        }

        return drawingResults;
    }

    public ProfitRateDto calculateProfitRate(final LottosDto lottosDto, final DrawingResultDto drawingResultDto) {
        Set<Entry<Rank, Integer>> results = drawingResultDto.drawingResults().entrySet();
        long totalRevenue = 0;

        for (Entry<Rank, Integer> result : results) {
            totalRevenue += (long) result.getKey().getWinningAmount() * result.getValue();
        }

        return toProfitRateDto(getProfitRate(lottosDto, (double) totalRevenue));
    }

    private double getProfitRate(LottosDto lottosDto, double totalRevenue) {
        long totalCost = (long) PurchaseAmount.PURCHASE_AMOUNT_UNIT * lottosDto.lottos().size();
        double profitRate = totalRevenue / totalCost * 100;

        return profitRate;
    }

    private ProfitRateDto toProfitRateDto(final double profitRate) {
        return new ProfitRateDto(profitRate);
    }
}
