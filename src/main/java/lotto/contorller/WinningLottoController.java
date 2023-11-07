package lotto.contorller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.WinningLotto;
import lotto.enumeration.NoticeType;
import lotto.service.TicketsService;
import lotto.util.Validator;

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
        System.out.println(NoticeType.WINNING_LOTTO_INPUT.getMessage());
        String lottoInput = Console.readLine();
        return ticketsService.stringToLotto(lottoInput);
    }

    public int getAmountInput() {
        System.out.println("\n" + NoticeType.AMOUNT_INPUT.getMessage());

        while(true) {
            String amountInput = Console.readLine();
            if(Validator.validateAmount(amountInput)) {
                System.out.println();
                return Integer.parseInt(amountInput);
            }
        }
    }

    public int getBonusNumInput() {
        System.out.println(NoticeType.BONUS_NUM_INPUT.getMessage());
        String bonusNumInput = Console.readLine();
        System.out.println();
        return Integer.parseInt(bonusNumInput);
    }

    public void init() {
        amount = getAmountInput();
        issueWinningLotto();
        winningLotto = ticketsService.getWinningLotto(getLottoInput(), getBonusNumInput());
    }

    public void issueWinningLotto() {
        tickets = ticketsService.issue(amount);
        printTickets();
    }

    public void getResult() {
        result = ticketsService.compare(tickets, winningLotto);
    }

    public void run() {
        init();
        getResult();
        getProfitRate();
        printResult();
    }

    public void getProfitRate() {
        profitRate = ticketsService.calcProfitRate(amount, result);
    }

    private void printResult() {
        System.out.println(NoticeType.WINNING_STATS.getMessage());
        ticketsService.printWinningStat(result);
        printProfitRate();
    }

    private void printProfitRate() {
       System.out.print(NoticeType.PROFIT_FRONT.getMessage() + profitRate + NoticeType.PROFIT_END.getMessage());
    }

    private void printTickets() {
        System.out.println(tickets.size() + NoticeType.TICKET_COUNT.getMessage());
        tickets.forEach(Lotto::printNumbers);
        System.out.println();
    }

}
