package lotto.controller;

import lotto.Lotto;
import lotto.service.LottoGenerator;
import lotto.service.LottoIssuer;
import lotto.service.NumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String purchaseAmount = inputView.readPurchaseAmount();
        NumberGenerator<List<Integer>> generator = new LottoGenerator();
        Integer lottoTicket = buyLottoTicket(Integer.parseInt(purchaseAmount));
        LottoIssuer lottoIssuer = new LottoIssuer(lottoTicket, generator);
        List<Lotto> boughtLotto = lottoIssuer.issueLotto();
        outputView.printBoughtLotto(boughtLotto);
        List<Integer> winningNumbers = readWinningNumbers();
        Integer bonusNumber = readBonusNumber();
    }

    private List<Integer> readWinningNumbers() {
        return Arrays.stream(inputView.readWinningNumbers().split(","))
                .map(Integer::parseInt)
                .toList();
    }

    private Integer readBonusNumber() {
        return Integer.parseInt(inputView.readBonusNumber());
    }

    private Integer buyLottoTicket(Integer amount) {
        return amount / 1000;
    }
}
