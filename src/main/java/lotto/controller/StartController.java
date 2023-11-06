package lotto.controller;

import java.util.List;
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
    private Lotto lotto;
    private Bonus bonus;

    public void startLotto() {
        buyLotto();
        chooseHitLottoNumber();
    }

    private void buyLotto() {
        view.buyPriceMessage();
        buyPriceValidate();
        ticketInformation();
    }

    private void chooseHitLottoNumber() {
        view.sixHitLottoNumberMessage();
        sixHitNumberValidate();
        view.bonusHitNumberMessage();
        bonusHitNumberValidate();
    }

    private void ticketInformation() {
        buyTicketCount();
        lottoTicket();
    }

    private void buyTicketCount() {
        view.buyTicketCountMessage(buy.getBuyTicketCount());
    }

    private void lottoTicket() {
        Ticket lottoTicketCount = new Ticket(buy.getBuyTicketCount());
        lottoTicketNumbers(lottoTicketCount);
    }

    private void lottoTicketNumbers(Ticket lottoTicketCount) {
        view.lottoTicketInformation(lottoTicketCount.getLottoTicket());
    }

    private void buyPriceValidate() {
        try {
            buy = new Buy(view.inputConsole());
            System.out.println();
        } catch (IllegalArgumentException e) {
            buyPriceValidate();
        }
    }

    private void sixHitNumberValidate() {
        try {
            lotto = new Lotto(inputSixHitLottoNumber());
        } catch (IllegalArgumentException e) {
            sixHitNumberValidate();
        }
    }

    private List<Integer> inputSixHitLottoNumber() {
        List<String> inputSixNumber = utils.stringToStringList(view.inputConsole());
        Validate.inputSixHitLottoNumberValidate(inputSixNumber);
        return utils.stringListToIntegerList(inputSixNumber);
    }

    private void bonusHitNumberValidate() {
        try {
            bonus = new Bonus(inputBonusHitNumber());
            compareLottoAndBonusNumberValidate();
        } catch (IllegalArgumentException e) {
            bonusHitNumberValidate();
        }
    }

    private int inputBonusHitNumber() {
        String inputBonusNumber = view.inputConsole();
        Validate.inputBonusHitLottoNumberValidate(inputBonusNumber);
        return Integer.parseInt(inputBonusNumber);
    }

    private void compareLottoAndBonusNumberValidate() {
        Validate.compareLottoAndBonusNumberValidate(lotto.getNumbers(), bonus.getNumber());
    }
}
