package lotto.control;


import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.Prize;
import lotto.service.LottoTicketGenerator;
import lotto.service.PrizeStatisticService;
import lotto.service.UserRequestService;
import lotto.view.OutputView;

public class Control {
    public static void playLotto() {
        int lottoCost = startLotto();
        LottoTicket ticket = generateLotto(calculateTicketCount(lottoCost));
        resultLotto(ticket, lottoCost);
    }

    private static int startLotto() {
        int lottoCost = UserRequestService.requestLottoCost();
        int lottoTicketCount = calculateTicketCount(lottoCost);
        OutputView.printLottoTicketCount(lottoTicketCount);
        return lottoCost;
    }

    private static LottoTicket generateLotto(int lottoTicketCount) {
        LottoTicket ticket = LottoTicketGenerator.generateLottoTickets(lottoTicketCount);
        LottoTicketGenerator.printLottoTickets(ticket);
        return ticket;
    }

    private static void resultLotto (LottoTicket ticket, int lottoCost) {
        Lotto winningLotto = UserRequestService.requestWinningLotto();
        int bonusNumber = UserRequestService.requestBonusNumber(winningLotto.getNumbers());

        Map<Prize, Integer> matchNumberCount = ticket.compilePrizeStatistics(winningLotto, bonusNumber);
        int totalPrize = PrizeStatisticService.processAndReportPrizeResults(matchNumberCount);

        OutputView.printProfitRate(totalPrize, lottoCost);
    }

    public static int calculateTicketCount(int lottoCost) {
        return lottoCost / 1000;
    }
}
