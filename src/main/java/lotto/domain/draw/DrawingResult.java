package lotto.domain.draw;

import java.util.EnumMap;
import lotto.domain.lotto.LottoRank;
import lotto.domain.money.Money;

public class DrawingResult {
    private final EnumMap<LottoRank, Integer> drawingResult;

    public DrawingResult(EnumMap<LottoRank, Integer> drawingResult) {
        this.drawingResult = drawingResult;
    }

    public double calculateProfitRate() {
        double totalPrize = sumTotalPrize();
        int countOfLottoTickets = countLottoTickets();
        double profitRate = totalPrize / (countOfLottoTickets * Money.LOTTO_PRICE) * 100.0;
        return Math.round(profitRate * 10.0) / 10.0;
    }

    private double sumTotalPrize() {
        return drawingResult.keySet().stream()
                .mapToLong(rank -> rank.getPrize() * drawingResult.get(rank))
                .sum();
    }

    private int countLottoTickets() {
        System.out.println("drawingResult.values() = " + drawingResult.values());
        return drawingResult.values().stream()
                .filter(ticketCount -> ticketCount > 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public EnumMap<LottoRank, Integer> getDrawingResult() {
        return drawingResult;
    }
}
