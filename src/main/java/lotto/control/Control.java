package lotto.control;


import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.Prize;
import lotto.service.LottoTicketGenerator;
import lotto.service.PrizeStatisticAccumulator;
import lotto.service.PrizeStatisticService;
import lotto.service.UserRequestService;
import lotto.view.OutputView;

public class Control {
    public static void playLotto() {
        int lottoCost = startLotto();
        generateLotto(calculateTicketCount(lottoCost));
        resultLotto(lottoCost);
    }

    private static int startLotto() {
        int lottoCost = UserRequestService.requestLottoCostWithException();
        int lottoTicketCount = calculateTicketCount(lottoCost);
        OutputView.printLottoTicketCount(lottoTicketCount);
        return lottoCost;
    }

    private static void generateLotto(int lottoTicketCount) {
        LottoTicket ticket = LottoTicketGenerator.generateLottoTickets(lottoTicketCount);
        LottoTicketGenerator.printLottoTickets(ticket);
    }

    private static void resultLotto (int lottoCost) {
        Lotto winningLotto = UserRequestService.requestWinningLottoWithException();
        int bonusNumber = UserRequestService.requestBonusNumberWithException(winningLotto.getNumbers());

        Map<Prize, Integer> matchNumberCount = PrizeStatisticAccumulator.compilePrizeStatistics(winningLotto, bonusNumber);
        int totalPrize = PrizeStatisticService.reportPrizeResults(matchNumberCount);

        OutputView.printProfitRate(totalPrize, lottoCost);
    }

    public static int calculateTicketCount(int lottoCost) {
        return lottoCost / 1000;
    }
}
