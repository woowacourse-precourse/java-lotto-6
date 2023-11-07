package lotto.controller;

import lotto.model.LottoTicket;
import lotto.service.LottoService;
import lotto.view.TypeConverter;
import lotto.view.output.OutputView;

public class LottoController implements TypeConverter {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public OutputView createLottoTicket(String input) {
        long money = toLong(input);
        LottoTicket ticket = lottoService.buyLotto(money);
        return OutputView.of(ticket);
    }
}
