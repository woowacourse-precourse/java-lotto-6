package lotto.controller;

import static lotto.message.SystemMessage.OUTPUT_PURCHASE_LOTTO_AMOUNT;

import java.util.List;
import lotto.domain.Lotto;
import lotto.handler.InputHandler;
import lotto.handler.OutputHandler;
import lotto.service.LottoService;
import lotto.view.OutputView;

public class GameController {
    private GameController() {
    }

    public static void game() {
        int lottoPurchasePrice = InputHandler.setLottoPurchasePrice();
        List<Lotto> lottos = LottoService.issueLottoTickets(lottoPurchasePrice);
        OutputHandler.outputLottosInfo(lottos);


    }

}
