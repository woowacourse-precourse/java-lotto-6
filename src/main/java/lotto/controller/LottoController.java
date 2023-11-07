package lotto.controller;

import lotto.service.LottoService;
import lotto.view.LottoView;

import java.util.Collections;
import java.util.stream.IntStream;

public class LottoController {

    private final LottoService lottoService;

    private final LottoView lottoView;


    public LottoController(LottoService lottoService, LottoView lottoView) {
        this.lottoService = lottoService;
        this.lottoView = lottoView;
    }

    public void inputMoney() {
        lottoView.inputMoneyView();
        lottoService.buyLottoTickets();
    }

    public void getLottoTicketsInfo() {
        lottoView.outputBuyLottoTicketsView(lottoService.getTicketCount());
        lottoView.outputLottoTicketNumbersView(lottoService.getLottoTickets());
    }

    public void setLottoWinningNumbers() {
        lottoView.inputWinnerNumbersView();
        lottoService.inputWinnerNumbers();

        lottoView.inputBonusNumberView();
        lottoService.inputBonusNumber();
    }

}
