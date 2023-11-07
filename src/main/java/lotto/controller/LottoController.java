package lotto.controller;

import lotto.dto.LottoResultDto;
import lotto.mapper.LottoResultDtoMapper;
import lotto.mapper.LottoTicketsDtoMapper;
import lotto.dto.LottoTicketsDto;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.LottoTickets;
import lotto.model.Money;
import lotto.model.WinningLotto;
import lotto.util.RandomLottoGenerator;
import lotto.view.Output;

public class LottoController {
    public void start() {
        Money money = InputController.getMoney();

        LottoTickets lottoTickets = getLottoTickets(money);
        LottoTicketsDto lottoTicketsDto = LottoTicketsDtoMapper.from(lottoTickets);
        Output.printLottoTickets(lottoTicketsDto);

        WinningLotto winningLotto = getWinningLotto();
        LottoResult lottoResult = LottoResult.calculateLottoResult(winningLotto, lottoTickets);
        LottoResultDto lottoResultDto = LottoResultDtoMapper.from(lottoResult);
        Output.printLottoResult(lottoResultDto);

        Output.printLottoRate(lottoResult.getRate(money));
    }

    private LottoTickets getLottoTickets(Money money) {
        int ticket = money.getTicket();
        return LottoTickets.generateRandomLottoTickets(new RandomLottoGenerator(), ticket);
    }

    private WinningLotto getWinningLotto() {
        Lotto winningLotto = InputController.getWinningNumbers();
        BonusNumber bonusNumber = InputController.getBonusNumber();
        return new WinningLotto(winningLotto, bonusNumber);
    }
}
