package lotto.contorller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.Tickets;
import lotto.domain.WinningLotto;
import lotto.service.TicketsService;

public class WinningLottoController {
    WinningLotto winningLotto;
    Tickets tickets;
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
        winningLotto = ticketsService.getUserLotto(getLottoInput(), getBonusNumInput());
        tickets = new Tickets(getAmountInput());
        issueWinningLotto(tickets.calcTicketCount());
    }
    private final TicketsService winningLottoService = new TicketsService();
    public void issueWinningLotto(int count) {
        tickets = winningLottoService.issue(tickets);
        tickets.printWinningLotto();
    }
}
