package lotto;

import java.util.List;
import lotto.controller.LottoInputController;

public class Application {
    public static void main(String[] args) {
        LottoInputController inputController = LottoInputController.getInstance();
        int amount = inputController.getUserInputForAmount();

        List<Integer> winningNumbers = inputController.getUserInputForWinningNumbers();
        int bonusNumber = inputController.getUserInputForBonusNumber(winningNumbers);
    }
}
