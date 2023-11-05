package lotto.controller;

import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Tickets;
import lotto.domain.convert.ConverToInt;
import lotto.domain.convert.ConvertToList;

public class LottoController {

    public void gernerateTicket(final String walletNumber) {
        ConverToInt walletConvertor = ConverToInt.from(walletNumber);
        int wallet = walletConvertor.getValue();

        Tickets tickets = new Tickets(wallet);
        tickets.generate();
    }

    public void inputLotto(final String lottoNumber, final String bonusNumber) {
        ConvertToList lottoConvertor = ConvertToList.from(lottoNumber);
        ConverToInt bonusConvertor = ConverToInt.from(bonusNumber);

        List<Integer> numbers = lottoConvertor.getValue();
        int bonus = bonusConvertor.getValue();

        validateInput(numbers, bonus);
    }

    private void validateInput(List<Integer> numbers, int bonus) {
        new Lotto(numbers);
        new Bonus(bonus);
    }

    public void compareWinning() {

    }

    public void verifyWinRecord() {

    }

    public void verifyReturns() {

    }

}
