package lotto.contorller;

import camp.nextstep.edu.missionutils.Console;
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
    int amount;
    private final LottoService ticketsService = new LottoService();

    public Lotto getLottoInput() {
        System.out.println(NoticeType.WINNING_LOTTO_INPUT.getMessage());

        while (true) {
            String lottoInput = Console.readLine();
            try {
                System.out.println();
                Validator.validateLottoInput(lottoInput);
                return ticketsService.stringToLotto(lottoInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getAmountInput() {
        System.out.println("\n" + NoticeType.AMOUNT_INPUT.getMessage());

        while (true) {
            String amountInput = Console.readLine();
            if (Validator.validateAmount(amountInput)) {
                System.out.println();
                return Integer.parseInt(amountInput);
            }
        }
    }

    public int getBonusNumInput() {
        System.out.println(NoticeType.BONUS_NUM_INPUT.getMessage());

        while (true) {
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
