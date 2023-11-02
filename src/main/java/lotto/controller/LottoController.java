package lotto.controller;

import lotto.Lotto;
import lotto.service.LottoGenerator;
import lotto.service.LottoIssuer;
import lotto.service.NumberGenerator;
import lotto.view.InputView;

import java.util.List;

public class LottoController {

    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        String purchaseAmount = inputView.readPurchaseAmount();
        NumberGenerator<List<Integer>> generator = new LottoGenerator();
        Integer lottoTicket = buyLottoTicket(Integer.parseInt(purchaseAmount));
        LottoIssuer lottoIssuer = new LottoIssuer(lottoTicket, generator);
        List<Lotto> boughtLotto = lottoIssuer.issueLotto();

    }

    private Integer buyLottoTicket(Integer amount) {
        return amount / 1000;
    }
}
