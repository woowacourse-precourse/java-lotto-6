package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Tickets;
import lotto.domain.convert.LottoConvertor;

public class LottoController {

    public void gernerateTicket(final String wallet) {
        Tickets tickets = Tickets.from(wallet);
        tickets.generate();
    }

    public void inputLotto(String winNumber, String bonusNumber) {
        LottoConvertor lottoConvertor = LottoConvertor.from(winNumber);
        List<Integer> winNumbers = lottoConvertor.getWinNumbers();
        new Lotto(winNumbers);
    }

    public void compareWinning() {

    }

    public void verifyWinRecord() {

    }

    public void verifyReturns() {

    }

}
