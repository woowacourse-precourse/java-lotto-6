package lotto.contorller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.Result;
import lotto.domain.WinningLotto;
import lotto.enumeration.NoticeType;
import lotto.service.LottoService;
import lotto.service.ResultService;
import lotto.util.Validator;

import java.math.BigDecimal;
import java.util.List;

public class LottoController {
    WinningLotto winningLotto;
    Amount amount;
    List<Lotto> tickets;
    Result result;
    BigDecimal profitRate;
    private final LottoService lottoService = new LottoService();
    private final ResultService resultService = new ResultService();

    public Lotto getLottoInput() {
        while (true) {
            System.out.println(NoticeType.WINNING_LOTTO_INPUT.getMessage());
            String lottoInput = Console.readLine();
            if(!Validator.validateLottoInput(lottoInput)) {
                continue;
            }
            try {
                System.out.println();
                return lottoService.stringToLotto(lottoInput);
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
                winningLotto = lottoService.getWinningLotto(lotto, bonus);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void run() {
        init();
        getResult();
        getProfitRate();
        printResult();
        printProfitRate();
    }

    public void issueTickets() {
        tickets = lottoService.issue(amount.getTicketCount());
        printTickets();
    }

    private void printTickets() {
        System.out.println(tickets.size() + NoticeType.TICKET_COUNT.getMessage());
        tickets.forEach(Lotto::printNumbers);
        System.out.println();
    }

    public void getResult() {
        result = lottoService.compare(tickets, winningLotto);
    }

    public void getProfitRate() {
        profitRate = resultService.calcProfitRate(result, amount.getAmount());
    }

    private void printResult() {
        System.out.println(NoticeType.WINNING_STATS.getMessage());
        resultService.printWinningStat(result);
        printProfitRate();
    }

    private void printProfitRate() {
        System.out.print(NoticeType.PROFIT_FRONT.getMessage() + profitRate + NoticeType.PROFIT_END.getMessage());
    }

}
