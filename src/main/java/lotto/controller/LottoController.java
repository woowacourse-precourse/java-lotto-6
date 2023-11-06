package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.Lottos;
import lotto.model.PrizePercentage;
import lotto.model.PurchaseAmount;
import lotto.model.Result;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void startGame() {
        PurchaseAmount purchaseAmount = readPurchaseAmount();
        Lottos lottos = purchaseLottos(purchaseAmount);
        OutputView.printLottoNumbers(lottos);

        WinningLotto winningLotto = createWinningLotto();
        Result result = lottos.compareLottos(winningLotto);
        OutputView.printResult(result);

        PrizePercentage prizePercentage = purchaseAmount.calculatePrizePercentage(result);
        OutputView.printProfitPercentage(prizePercentage.getPrizePercentage());
    }

    private PurchaseAmount readPurchaseAmount() {
        while (true) {
            try {
                PurchaseAmount purchaseAmount = new PurchaseAmount(InputView.readPurchaseAmount());
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lottos purchaseLottos(PurchaseAmount purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < purchaseAmount.divideByThousand(); i++) {
            Lotto lotto = LottoGenerator.createLotto();
            lottos.add(lotto);
        }

        return new Lottos(lottos);
    }

    private WinningLotto createWinningLotto() {
        Lotto winningNumbers = LottoGenerator.createLotto(readWinningNumbers());
        BonusNumber bonusNumber = readBonusNumber(winningNumbers);
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private List<Integer> readWinningNumbers() {
        while (true) {
            try {
                return InputView.readWinningNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private BonusNumber readBonusNumber(Lotto winningNumbers) {
        while (true) {
            try {
                BonusNumber bonusNumber = new BonusNumber(InputView.readBonusNumber());
                bonusNumber.validateIsDuplicate(winningNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
