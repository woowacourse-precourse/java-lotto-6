package lotto.controller.inputController;

import lotto.model.lottoResultChecker.LottoBonus;
import lotto.view.inputView.LottoBonusWinningNumberInput;
import java.util.List;

public class LottoBonusWinningNumberController {
    private final LottoBonusWinningNumberInput bonusNumberInput;

    public LottoBonusWinningNumberController() {
        this.bonusNumberInput = new LottoBonusWinningNumberInput();
    }

    public LottoBonus receiveAndCreateLottoBonus(List<Integer> winningNumbers) {
        while (true) {
            try {
                String input = bonusNumberInput.requestBonusNumber();
                return new LottoBonus(input, winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
