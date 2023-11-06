package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.constant.LottoPrize;
import lotto.model.Lotto;
import lotto.view.OutputView;

public class OutputController {
    private final OutputView outputView;
    private final String NEW_LINE = "\n";

    public OutputController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void printLottoTicketsCount(int count) {
        String lottoTicketsCountText = creatLottoTicketsCountText(count);
        outputView.updateLottoTicketsCountText(lottoTicketsCountText);
        outputView.renderLottoTicketsCountText();
    }

    public void printLottoTickets(List<Lotto> lottoTickets) {
        String lottoTicketsText = createLottoTicketsText(lottoTickets);
        outputView.updateLottoTicketsText(lottoTicketsText);
        outputView.renderLottoTicketsText();
    }

    public void printPrizeCounter(Map<LottoPrize, Integer> prizeCounter) {
        String prizeCounterText = createPrizeCounterText(prizeCounter);
        outputView.updatePrizeCounterText(prizeCounterText);
        outputView.renderPrizeCounterText();
    }

    public void printRateOfReturn(double rateOfReturn) {
        String rateOfReturnText = createRateOfReturnText(rateOfReturn);
        outputView.updateRateOfReturnText(rateOfReturnText);
        outputView.renderRateOfReturnText();
    }

    public String creatLottoTicketsCountText(int count) {
        return String.valueOf(count);
    }

    public String createLottoTicketsText(List<Lotto> lottoTickets) {
        StringBuilder sb = new StringBuilder();
        lottoTickets.forEach(lotto -> {
            sb.append(lotto.toString())
                    .append(NEW_LINE);
        });
        return sb.toString();
    }

    public String createPrizeCounterText(Map<LottoPrize, Integer> prizeCounter) {
        StringBuilder sb = new StringBuilder();
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            if (lottoPrize == LottoPrize.NOTHING) {
                continue;
            }
            int count = prizeCounter.get(lottoPrize);
            sb.append(String.format(lottoPrize.getStatisticsFormat(), count))
                    .append(NEW_LINE);
        }
        return sb.toString();
    }

    public String createRateOfReturnText(double rateOfReturn) {
        String ROUND_TO_FIRST_DECIMAL_PLACE_FORMAT = "%.1f";
        return String.format(ROUND_TO_FIRST_DECIMAL_PLACE_FORMAT, rateOfReturn);
    }
}