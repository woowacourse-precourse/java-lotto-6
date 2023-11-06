package lotto.domain.draw;

import java.util.EnumMap;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoRank;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningCombination;

public class DrawingMachine {

    public DrawingMachine() {

    }

    public DrawingResult draw(WinningCombination winningCombination, Lottos totalLottoTickets) {
        EnumMap<LottoRank, Integer> drawingResult = evaluateDrawingResult(winningCombination, totalLottoTickets);
        return new DrawingResult(drawingResult);
    }

    private EnumMap<LottoRank, Integer> evaluateDrawingResult(WinningCombination winningCombination,
                                                              Lottos totalLottoTickets) {
        EnumMap<LottoRank, Integer> drawingResult = initializeDrawingResult();
        List<Lotto> lottoTickets = totalLottoTickets.getLottos();
        lottoTickets.forEach(
                lottoTicket -> updateDrawingResult(drawingResult, winningCombination.getLottoRankFrom(lottoTicket)));
        return drawingResult;
    }

    private EnumMap<LottoRank, Integer> initializeDrawingResult() {
        EnumMap<LottoRank, Integer> drawingResult = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.ranks) {
            drawingResult.put(rank, 0);
        }
        return drawingResult;
    }

    private void updateDrawingResult(EnumMap<LottoRank, Integer> drawingResult, LottoRank lottoRank) {
        if (drawingResult.containsKey(lottoRank)) {
            drawingResult.replace(lottoRank, drawingResult.get(lottoRank) + 1);
            return;
        }
        drawingResult.put(lottoRank, 1);
    }
}
