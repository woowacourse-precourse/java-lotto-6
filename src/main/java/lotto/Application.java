package lotto;
import java.util.List;
import lotto.inputAction.InputBonusNumber;
import lotto.inputAction.InputPurchaseAmount;
import lotto.inputAction.InputWinningNumbers;

public class Application {
    public static void main(String[] args) {

        InputPurchaseAmount inputPurchaseAmount = new InputPurchaseAmount();
        InputWinningNumbers inputWinningNumbers = new InputWinningNumbers();
        InputBonusNumber inputBonusNumber = new InputBonusNumber();

        try {
            int purchaseAmount = inputPurchaseAmount.inputPurchaseAmount();
            int lottoCount = purchaseAmount / 1000;
            LottoGame game = new LottoGame(lottoCount);

            game.printLottoTickets();

            List<Integer> winningNumbers = inputWinningNumbers.inputWinningNumbers();
            int bonusNumber = inputBonusNumber.inputBonusNumber();
            game.checkWinning(winningNumbers, bonusNumber);

            game.printStatistics();
            game.calculateProfitRate(purchaseAmount);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
