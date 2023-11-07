package lotto.facade;

import lotto.domain.*;
import lotto.input.UserInputAdapter;
import lotto.output.LottoGameViewOutputPort;

import java.util.Map;

public class LottoGameFacade {
    private final UserInputAdapter userInputAdapter;
    private final LottoGameViewOutputPort lottoGameViewOutputPort;
    private final LottoMarket lottoMarket;
    private final LottoProfitRateCalculator lottoProfitRateCalculator;

    public LottoGameFacade(
            UserInputAdapter userInputAdapter,
            LottoGameViewOutputPort lottoGameViewOutputPort,
            LottoMarket lottoMarket,
            LottoProfitRateCalculator lottoProfitRateCalculator
    ) {
        this.userInputAdapter = userInputAdapter;
        this.lottoGameViewOutputPort = lottoGameViewOutputPort;
        this.lottoMarket = lottoMarket;
        this.lottoProfitRateCalculator = lottoProfitRateCalculator;
    }

    public void game() {
        LottoTicket ticket = buyLotto();
        Map<LottoGrade, Integer> statistics = getStatistics(ticket);
        calculateProfitRate(statistics);
    }

    private LottoTicket buyLotto() {
        int lottoBuyPrice = userInputAdapter.getLottoBuyPrice();
        LottoTicket ticket = lottoMarket.buyLotto(lottoBuyPrice);
        lottoGameViewOutputPort.printLottoCount(lottoBuyPrice);
        lottoGameViewOutputPort.printGeneratedLottoList(ticket);

        return ticket;
    }

    private Map<LottoGrade, Integer> getStatistics(LottoTicket ticket) {
        LottoAnswer lottoAnswer = userInputAdapter.getLottoAnswer();
        Map<LottoGrade, Integer> statistics = ticket.getLottoStatistics(lottoAnswer);
        lottoGameViewOutputPort.printLottoResult(statistics);

        return statistics;
    }

    private void calculateProfitRate(Map<LottoGrade, Integer> statistics) {
        LottoProfitRate profitRate = lottoProfitRateCalculator.calculate(statistics);
        lottoGameViewOutputPort.printLottoProfitRate(profitRate.getValueByString());
    }
}
