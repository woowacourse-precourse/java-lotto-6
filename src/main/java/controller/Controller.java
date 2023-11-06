package controller;

import View.InputView;
import View.OutputView;
import java.util.Map;
import java.util.Set;
import lotto.Buyer;
import lotto.Lotto;
import lotto.LottoMachine;
import lotto.PlayLotto;
import lotto.Rank;
import utils.Util;

public class Controller {
    private final LottoMachine lottoMachine;
    private final InputView inputView;
    private Buyer buyer;

    public Controller(LottoMachine lottoMachine, InputView inputView) {
        this.lottoMachine = lottoMachine;
        this.inputView = inputView;
    }

    public void run() {
        int purchaseAmount = askPurchaseAmount();
        buyer = new Buyer(purchaseAmount, lottoMachine);
        buyLotto(buyer);

        PlayLotto playLotto = startLotto();

        playLotto.lottoResult(buyer.getMyLotteries());
        Map<Rank, Integer> lottoResult = playLotto.getLottoResult();

        for (Rank key : Rank.values()) {
            OutputView.printWinResult(key.getMessage(lottoResult.get(key)));
        }

        long prizeSum = playLotto.prizeSum();
        OutputView.printReturnOfRate(buyer.calculateReturnRate(prizeSum));

    }

    private int askPurchaseAmount() {
        OutputView.promptPurchaseAmount();
        try {
            String puchasePrice = inputView.inputPuchasePrice();
            return Integer.parseInt(puchasePrice) / Lotto.LOTTO_PRICE;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return askPurchaseAmount();
        }
    }

    private void buyLotto(Buyer buyer) {
        buyer.buyLotteries();
        OutputView.printPurchaseAmount(buyer.getPurchaseAmount());
        OutputView.printLottos(buyer.getMyLotteries());
    }

    private PlayLotto startLotto() {
        Set<Integer> prizeNumbers = askPrizeNumbers();
        int bonusNumber = askBonusNumber();
        return new PlayLotto(prizeNumbers, bonusNumber);
    }

    private Set<Integer> askPrizeNumbers() {
        OutputView.promptPrizeNumbers();
        try {
            String inputPrizeNumbers = inputView.inputPrizeNumbers();
            return Util.stringToIntegerSet(inputPrizeNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return askPrizeNumbers();
        }

    }

    private int askBonusNumber() {
        OutputView.promptBonusNumber();
        try {
            String inputBonusNumber = inputView.inputBonusNumber();
            //ask메서드 둘 다 예외처리 수정하기
            return Integer.parseInt(inputBonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return askBonusNumber();
        }

    }
}
