package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.common.utils.Utils;
import lotto.common.validate.Validate;
import lotto.domain.Buy;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.view.View;

public class LottoController {
    View view = new View();
    Utils utils = new Utils();

    private Buy buy;
    private Lotto lotto;

    public void startLotto() {
        buyLotto();
        chooseHitLottoNumber();
    }

    private void buyLotto() {
        view.buyPriceMessage();
        buyPriceValidate();
        System.out.println();
        buyLottoPrice(buy);
        lottoTicket(buy);
    }

    private void chooseHitLottoNumber() {
        view.sixHitLottoNumberMessage();
        sixHitNumberValidate();
        // sixHitNumber, bonusHitNumber
    }

    private void buyPriceValidate() {
        try {
            buy = new Buy(view.inputConsole());
        } catch (IllegalArgumentException e) {
            buyPriceValidate();
        }
    }

    private void buyLottoPrice(Buy buy) {
        view.buyTicketCountMessage(buy.getBuyTicketCount());
    }

    private void lottoTicket(Buy buy) {
        LottoTicket lottoTicketCount = new LottoTicket(buy.getBuyTicketCount());
        lottoTicketNumbers(lottoTicketCount);
    }

    private void lottoTicketNumbers(LottoTicket lottoTicketCount) {
        view.lottoTicketInformation(lottoTicketCount.getLottoTicket());
    }

    private void sixHitNumberValidate() {
        try {
            lotto = new Lotto(inputSixHitLottoNumber());
        } catch (IllegalArgumentException e) {
            sixHitNumberValidate();
        }
    }

    public List<Integer> inputSixHitLottoNumber() {
        List<String> inputSixNumber = utils.stringToStringList(view.inputConsole());
        Validate.inputSixHitLottoNumberValidate(inputSixNumber);
        return utils.stringListToIntegerList(inputSixNumber);
    }
}
