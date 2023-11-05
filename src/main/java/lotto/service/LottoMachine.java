package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import lotto.domain.DrawingResults;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.dto.BonusNumberDto;
import lotto.domain.dto.DrawingResultDto;
import lotto.domain.dto.LottoDto;
import lotto.domain.dto.LottosDto;
import lotto.domain.dto.PurchaseAmountDto;
import lotto.domain.dto.WinningLottoDto;

public class LottoMachine {

    public LottosDto issuedLottos(final PurchaseAmountDto purchaseAmountDto) {
        List<Lotto> lottos = new Lottos(purchaseAmountDto).getLottos();

        return new LottosDto(toLottoDto(lottos));
    }

    private List<LottoDto> toLottoDto(final List<Lotto> lottos) {
        List<LottoDto> lottoStore = new ArrayList<>();

        for (Lotto lotto : lottos) {
            LottoDto lottoDto = new LottoDto(lotto.getNumbers());
            lottoStore.add(lottoDto);
        }

        return lottoStore;
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

    public double calculateProfitRate(final LottosDto lottosDto, final DrawingResultDto drawingResultDto) {
        Set<Entry<Rank, Integer>> results = drawingResultDto.drawingResults().entrySet();
        long totalRevenue = 0;

        for (Entry<Rank, Integer> result : results) {
            totalRevenue += (long) result.getKey().getWinningAmount() * result.getValue();
        }

        long totalCost = (long) PurchaseAmountDto.PURCHASE_AMOUNT_UNIT * lottosDto.lottos().size();
        return (double) totalRevenue / totalCost * 100;
    }
}
