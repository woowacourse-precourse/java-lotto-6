package lotto.controller;

import lotto.common.validate.Validate;
import lotto.domain.Bonus;
import lotto.domain.Buy;
import lotto.domain.Lotto;
import lotto.domain.Ticket;
import lotto.view.View;

public class StartController {

    View view = new View();

    private Buy buy;
    private Ticket ticket = new Ticket();
    private Lotto lotto;
    private Bonus bonus;

    public void startLotto() {
        buyLotto();
        chooseHitLottoNumber();
        resultLotto();
    }

    private void buyLotto() {
        view.buyPriceMessage();
        buyPrice();
        ticketInformation();
    }

    private void chooseHitLottoNumber() {
        view.sixHitLottoNumberMessage();
        sixHitNumber();
        view.bonusHitNumberMessage();
        bonusHitNumber();
    }

    public void resultLotto() {
        view.prizeStatsMessage();
        view.compareTicketsAndLotto(ticket.getLottoTicket(), lotto.getNumbers(), bonus.getNumber());
        view.outputPrizeStats();
        view.outputProfitRate(buy.getBuyPrice());
    }

    private void buyPrice() {
        try {
            buy = new Buy(view.inputConsole());
            System.out.println();
        } catch (IllegalArgumentException e) {
            buyPrice();
        }
    }

    private void ticketInformation() {
        view.buyTicketCountMessage(buy.getBuyTicketCount());
        ticket.setLottoTicket(buy.getBuyTicketCount());
        view.lottoTicketNumbers(ticket.getLottoTicket());
    }

    private void sixHitNumber() {
        try {
            lotto = new Lotto(view.inputSixHitNumber());
            System.out.println();
        } catch (IllegalArgumentException e) {
            sixHitNumber();
        }
    }

    private void bonusHitNumber() {
        try {
            bonus = new Bonus(view.inputBonusHitNumber());
            Validate.compareLottoAndBonusNumberValidate(lotto.getNumbers(), bonus.getNumber());
            System.out.println();
        } catch (IllegalArgumentException e) {
            bonusHitNumber();
        }
    }
}
