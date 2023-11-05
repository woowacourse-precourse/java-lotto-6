package lotto.controller;

import java.util.List;
import lotto.mapper.LottoTicketsDtoMapper;
import lotto.dto.LottoTicketsDto;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoTickets;
import lotto.model.Money;
import lotto.model.WinningLotto;
import lotto.util.RandomLottoGenerator;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {
    public void start() {
        Money money = getMoney();

        LottoTickets lottoTickets = getLottoTickets(money);
        LottoTicketsDto lottoTicketsDto = LottoTicketsDtoMapper.from(lottoTickets);
        Output.printLottoTickets(lottoTicketsDto);

        WinningLotto winningLotto = getWinningLotto();
    }

    private Money getMoney() {
        return new Money(Input.inputMoney());
    }

    private LottoTickets getLottoTickets(Money money) {
        int ticket = money.getTicket();
        return LottoTickets.generateLottoTickets(new RandomLottoGenerator(), ticket);
    }

    private WinningLotto getWinningLotto() {
        Lotto winningLotto = new Lotto(Input.inputWinningLotto());
        BonusNumber bonusNumber = new BonusNumber(Input.inputBonusNumber());
        return new WinningLotto(winningLotto, bonusNumber);
    }
}
