package lotto.controller;

import java.util.ArrayList;
import java.util.List;
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
        List<Integer> winningNumbers = readWinningNumbers();
        int bonusNumber = readBonusNumber(winningNumbers);
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

    private int readBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                int bonusNumber = InputView.readBonusNumber();
                validateIsDuplicate(winningNumbers, bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateIsDuplicate(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호과 중복되지 않는 숫자를 입력해야 합니다.");
        }
    }
}
