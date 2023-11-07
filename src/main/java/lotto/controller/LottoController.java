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
    final InputController inputController = new InputController();

    public void start() {
        Money money = inputController.getMoney();

        LottoTickets lottoTickets = getLottoTickets(money);
        LottoTicketsDto lottoTicketsDto = LottoTicketsDtoMapper.from(lottoTickets);
        Output.printLottoTickets(lottoTicketsDto, money.getLottoCount());

        WinningLotto winningLotto = getWinningLotto();
        LottoResult lottoResult = LottoResult.calculateLottoResult(winningLotto, lottoTickets);
        LottoResultDto lottoResultDto = LottoResultDtoMapper.from(lottoResult);
        Output.printLottoResult(lottoResultDto);

        Output.printLottoRate(lottoResult.getRate(money));
    }

    private LottoTickets getLottoTickets(Money money) {
        int lottoCount = money.getLottoCount();
        return LottoTickets.generateRandomLottoTickets(new RandomLottoGenerator(), lottoCount);
    }

    private WinningLotto getWinningLotto() {
        Lotto winningLotto = inputController.getWinningNumbers();
        BonusNumber bonusNumber = inputController.getBonusNumber(winningLotto);
        return new WinningLotto(winningLotto, bonusNumber);
    }
}
