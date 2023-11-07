package lotto.control;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.Prize;
import lotto.service.LottoTicketGenerator;
import lotto.service.PrizeStaticService;
import lotto.util.Converter;
import lotto.util.InputValidation;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Control {
    public static void playLotto() {
        int lottoCost = requestLottoCost();
        int lottoTicketCount = calculateTicketCount(lottoCost);
        OutputView.printLottoTicketCount(lottoTicketCount);

        LottoTicket ticket = LottoTicketGenerator.generateLottoTickets(lottoTicketCount);
        LottoTicketGenerator.printLottoTickets(ticket);

        Lotto winningLotto = requestWinningLotto();
        int bonusNumber = requestBonusNumber(winningLotto.getNumbers());

        Map<Prize, Integer> matchNumberCount = ticket.compilePrizeStatistics(winningLotto, bonusNumber);
        int totalWinnings = PrizeStaticService.calculateAndDisplayPrizeStatistics(matchNumberCount);

        OutputView.printProfitRate(totalWinnings, lottoCost);
    }
    public static int calculateTicketCount(int lottoCost) {
        return lottoCost / 1000;
    }

    private static int requestLottoCost() {
        OutputView.printRequestLottoPrice();
        String input = InputView.requestPrice();
        try {
            InputValidation.validatePrice(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestLottoCost();
        }
    }

    private static Lotto requestWinningLotto() {
        OutputView.printRequestWinningNumbers();
        List<Integer> winningNumbers = Converter.toIntegerList(InputView.requestWinningNumber());
        try {
            InputValidation.validateLottoNumbers(winningNumbers);
            return new Lotto(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestWinningLotto();
        }
    }

    private static int requestBonusNumber(List<Integer> winningNumbers) {
        OutputView.printRequestBonusNumber();
        int bonusNumber = InputView.requestWinningBonusNumber();
        try {
            InputValidation.validateBonusNumber(String.valueOf(bonusNumber), winningNumbers);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestBonusNumber(winningNumbers);
        }
    }
}
