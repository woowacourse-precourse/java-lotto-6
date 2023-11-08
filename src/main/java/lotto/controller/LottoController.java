package lotto.controller;

import java.util.EnumMap;
import java.util.List;
import lotto.domain.Prize;
import lotto.domain.LottoTicket;
import lotto.io.Input;
import lotto.io.Output;
import lotto.service.LottoTicketService;

public class LottoController {
    public static void run() {
        LottoTicket lottoTicket = getTicket();
        List<Integer> winningNumbers = Input.winningNumbers();
        int bonusNumber = Input.bonusNumber(winningNumbers);
        printResult(lottoTicket, winningNumbers, bonusNumber);
    }

    private static LottoTicket getTicket() {
        int purchaseAmount = Input.purchaseAmount();
        LottoTicket lottoTicket = LottoTicketService.createTicket(purchaseAmount);
        Output.printTicket(lottoTicket);
        return lottoTicket;
    }

    private static void printResult(LottoTicket lottoTicket, List<Integer> winningNumbers, int bonusNumber) {
        EnumMap<Prize, Integer> statistics = LottoTicketService.getStatistics(lottoTicket, winningNumbers, bonusNumber);
        Output.printStatistics(statistics);
        Output.printProfitRate(lottoTicket, winningNumbers, bonusNumber);
    }
}
