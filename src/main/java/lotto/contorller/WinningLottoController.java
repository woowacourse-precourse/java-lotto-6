package lotto.contorller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.WinningLotto;
import lotto.enumeration.NoticeType;
import lotto.enumeration.WinningType;
import lotto.service.TicketsService;

import java.math.BigDecimal;
import java.util.List;

public class WinningLottoController {
    WinningLotto winningLotto;
    List<Lotto> tickets;
    Result result;
    BigDecimal profitRate;
    int amount;
    private final TicketsService ticketsService = new TicketsService();

    public Lotto getLottoInput() {
        String lottoInput = Console.readLine();
        return ticketsService.stringToLotto(lottoInput);
    }

    public int getAmountInput() {
        String amountInput = Console.readLine();
        return Integer.parseInt(amountInput);
    }

    public int getBonusNumInput() {
        String bonusNumInput = Console.readLine();
        return Integer.parseInt(bonusNumInput);
    }

    public void init() {
        winningLotto = ticketsService.getWinningLotto(getLottoInput(), getBonusNumInput());
        amount = getAmountInput();
        issueWinningLotto();
    }

    public void issueWinningLotto() {
        tickets = ticketsService.issue(amount);
    }

    public void getResult() {
        result = ticketsService.compare(tickets, winningLotto);
        for (WinningType winningType : WinningType.values()) {
            System.out.println(winningType.getMatchedCount() + " " +
                    result.getResult().get(winningType));
        }
    }

    public void run() {
        init();
        getResult();
        getProfitRate();

    }

    public void getProfitRate() {
        profitRate = ticketsService.calcProfitRate(amount, result);
    }

    private void printResult() {
        ticketsService.printWinningStat(result);
        printProfitRate();
    }

    private void printProfitRate() {
       System.out.println(NoticeType.PROFIT_FRONT + String.valueOf(profitRate) + NoticeType.PROFIT_END);
    }

}
