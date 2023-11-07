package lotto;

import java.util.List;
import java.util.Map;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.Rank;
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
        initBonusNumber();
        printResult();
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

    private void initBonusNumber() {
        while (true) {
            try {
                Integer bonusNumber = inputView.writeBonusNumber();
                lottoController.validateBonusNumber(bonusNumber);
                if (isAvailBonusNumbers(bonusNumber)) {
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean isAvailBonusNumbers(Integer bonusNumber) {
        return bonusNumber!=null;
    }

    private void printResult() {
        Map<Rank, Integer> finalResult = lottoController.provideResult();
        outputView.printResult(finalResult);
        double revenue = lottoController.provideRevenue();
        outputView.printRevenue(revenue);
    }

}
