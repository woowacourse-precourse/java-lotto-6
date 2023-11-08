package lotto.contorller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.WinningLotto;
import lotto.enumeration.NoticeType;
import lotto.service.LottoService;
import lotto.util.Validator;

import java.math.BigDecimal;
import java.util.List;

public class LottoController {
    WinningLotto winningLotto;
    List<Lotto> tickets;
    Result result;
    BigDecimal profitRate;
    Amount amount;
    private final LottoService ticketsService = new LottoService();

    public Lotto getLottoInput() {
        while (true) {
            System.out.println(NoticeType.WINNING_LOTTO_INPUT.getMessage());
            String lottoInput = Console.readLine();
            if(!Validator.validateLottoInput(lottoInput)) {
                continue;
            }
            try {
                System.out.println();
                return ticketsService.stringToLotto(lottoInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Amount getAmountInput() {
        while (true) {
            System.out.println("\n" + NoticeType.AMOUNT_INPUT.getMessage());
            String amountInput = Console.readLine();
            if(!Validator.validateAmountType(amountInput)) {
                continue;
            }
            try {
                return new Amount(Integer.parseInt(amountInput));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getBonusNumInput() {
        while (true) {
            System.out.println(NoticeType.BONUS_NUM_INPUT.getMessage());
            String bonusNumInput = Console.readLine();

            if (Validator.validateBonus(bonusNumInput)) {
                System.out.println();
                return Integer.parseInt(bonusNumInput);
            }
        }
    }

    public void init() {
        amount = getAmountInput();
        issueTickets();
        Lotto lotto = getLottoInput();
        while (true) {
            int bonus = getBonusNumInput();
            try {
                winningLotto = ticketsService.getWinningLotto(lotto, bonus);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void issueTickets() {
        tickets = ticketsService.issue(amount.getTicketCount());
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
        profitRate = ticketsService.calcProfitRate(amount.getAmount(), result);
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
