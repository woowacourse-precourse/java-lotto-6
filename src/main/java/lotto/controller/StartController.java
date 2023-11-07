package lotto.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.common.constants.LottoDefaultRule;
import lotto.common.constants.LottoRankRule;
import lotto.common.constants.Rank;
import lotto.common.utils.Utils;
import lotto.common.validate.Validate;
import lotto.domain.Bonus;
import lotto.domain.Buy;
import lotto.domain.Lotto;
import lotto.domain.Ticket;
import lotto.view.View;

public class StartController {


    View view = new View();
    Utils utils = new Utils();

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
        prizeStats();
        profitRate();
    }

    private void ticketInformation() {
        view.buyTicketCountMessage(buy.getBuyTicketCount());
        lottoTicket();
    }

    private void lottoTicket() {
        ticket.setLottoTicket(buy.getBuyTicketCount());
        view.lottoTicketNumbers(ticket.getLottoTicket());
    }

    private void buyPrice() {
        try {
            buy = new Buy(view.inputConsole());
            System.out.println();
        } catch (IllegalArgumentException e) {
            buyPrice();
        }
    }

    private void sixHitNumber() {
        try {
            lotto = new Lotto(inputSixHitNumber());
            System.out.println();
        } catch (IllegalArgumentException e) {
            sixHitNumber();
        }
    }

    private void bonusHitNumber() {
        try {
            bonus = new Bonus(inputBonusHitNumber());
            Validate.compareLottoAndBonusNumberValidate(lotto.getNumbers(), bonus.getNumber());
            System.out.println();
        } catch (IllegalArgumentException e) {
            bonusHitNumber();
        }
    }

    private List<Integer> inputSixHitNumber() {
        List<String> inputSixNumber = utils.stringToStringList(view.inputConsole());
        Validate.inputSixHitLottoNumberValidate(inputSixNumber);
        return utils.stringListToIntegerList(inputSixNumber);
    }

    private int inputBonusHitNumber() {
        String inputBonusNumber = view.inputConsole();
        Validate.inputBonusHitLottoNumberValidate(inputBonusNumber);
        return Integer.parseInt(inputBonusNumber);
    }

    // 당첨 내역 통계

    private void prizeStats() {
        view.prizeStatsMessage();
        compareTicketAndLottoAndBonus();
        // 당첨 통계 출력
    }

    private void profitRate() {
        // 수익률 출력
    }

    private void compareTicketAndLottoAndBonus() { // 당첨 통계 출력
        // System.out.println(lotto.getNumbers());  // 이번주 당첨 번호
        // System.out.println(ticket.getLottoTicket());  // 내가 산 자동형 로또
        view.compareTicketsAndLotto(ticket.getLottoTicket(), lotto.getNumbers(), bonus.getNumber());
    }
}
