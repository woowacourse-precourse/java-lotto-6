package lotto.controller;

import lotto.model.Lotto;
import lotto.service.LottoService;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    public static void run() {
        OutputView.printInputMoneyMsg();
        OutputView.printAmountOfLottoTickets();
        List<Lotto> lottoTickets = new ArrayList<>();
        lottoTickets = LottoService.makeLottoTickets();
        OutputView.printLottoTickets(lottoTickets);
    }
}