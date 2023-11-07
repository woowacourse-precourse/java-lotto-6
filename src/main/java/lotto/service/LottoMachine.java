package lotto.service;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import lotto.domain.DrawingResults;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.Rank;
import lotto.domain.dto.BonusNumberDto;
import lotto.domain.dto.DrawingResultDto;
import lotto.domain.dto.LottoDto;
import lotto.domain.dto.LottosDto;
import lotto.domain.dto.ProfitRateDto;
import lotto.domain.dto.WinningLottoDto;

public class LottoMachine {

    public Lottos issuedLottos(final PurchaseAmount purchaseAmount) {
        return new Lottos(purchaseAmount);
    }


    public DrawingResultDto draw(final LottosDto lottosDto, final WinningLottoDto winningLottoDto,
                                 final BonusNumberDto bonusNumberDto) {
        List<LottoDto> lottos = lottosDto.lottos();

        DrawingResults drawingResults = new DrawingResults();

        for (LottoDto lotto : lottos) {
            int matchedWinningLottoCount = lotto.matchWinningLottoCount(winningLottoDto);
            boolean hasBonusNumber = lotto.hasBonusNumber(bonusNumberDto);

            Rank calculateResult = Rank.calculate(matchedWinningLottoCount, hasBonusNumber);
            drawingResults.count(calculateResult);
        }

        return toDrawingResultDto(drawingResults);
    }

    private DrawingResultDto toDrawingResultDto(final DrawingResults drawingResults) {
        return new DrawingResultDto(drawingResults.getResults());
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
