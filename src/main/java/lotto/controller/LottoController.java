package lotto.controller;

import java.util.List;
import lotto.Mapper.LottoTicketsDtoMapper;
import lotto.dto.LottoTicketsDto;
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
        List<Integer> winningLotto = Input.inputWinningLotto();
        int bonusNumber = Input.inputBonusNumber();
        return new WinningLotto(winningLotto, bonusNumber);
    }
}
