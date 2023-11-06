package lotto.controller;

import java.util.List;
import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int count = getAmount();
        List<Lotto> lottos = createLotto(count);
    }

    private int getAmount() {
        String money = inputView.getPurchaseAmount();
        Amount amount = new Amount(money);
        return amount.getLottoCount();
    }

    private List<Lotto> createLotto(int count) {
        LottoMachine lottoMachine = new LottoMachine();
        Lottos lottos = new Lottos(lottoMachine.createAllLotto(count));
        outputView.printLottos(count, lottos.toResponseDto());
        return lottos.getLottos();
    }

    private void getWinningNumber() {
        String numbers = inputView.getWinningNumber();
//        WinningNumber winningNumber = new WinningNumber(numbers);
    }
}
