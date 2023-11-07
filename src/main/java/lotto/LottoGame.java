package lotto;

import java.util.List;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoController lottoController;

    public LottoGame() {
        inputView = new InputView();
        outputView = new OutputView();
        lottoController = new LottoController();
    }

    public void run() {
        String price = inputView.writePurchasePrice();
        List<Lotto> purchaseLotto = lottoController.buyTicket(price);
        outputView.printLottoTicket(purchaseLotto);
        initLuckyNumber();

    }

    private void initLuckyNumber() {
        while (true) {
            try {
                List<Integer> luckyNumbers = inputView.writeLuckyNumber();
                Lotto lotto = new Lotto(luckyNumbers);
                if (isAvailLuckyNumbers(lotto)) {
                    lottoController.setLuckyNumber(lotto);
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean isAvailLuckyNumbers(Lotto luckyNumber) {
        return luckyNumber!=null;
    }
}
