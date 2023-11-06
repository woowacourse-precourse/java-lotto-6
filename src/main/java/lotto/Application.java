package lotto;

import java.util.List;
import view.Input;
import view.Output;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = inputPurchaseAmount();
        Lotteries lotteries = new Lotteries(purchaseAmount);
        Output.printIssuedLotto(lotteries.getLotteries());
        Lotto winningNumbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber(winningNumbers);
    }

    private static int inputBonusNumber(Lotto winningNumbers) {
        while (true) {
            int bonusNumber;
            try {
                String input = Input.inputBonusNumber();
                bonusNumber = LottoNumber.validateLottoNumber(input);
                winningNumbers.isBonusNumberDuplicate(bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            return bonusNumber;
        }
    }

    private static Lotto inputWinningNumbers() {
        while (true) {
            Lotto lotto;
            try {
                String input = Input.inputWinningNumbers();
                List<Integer> winningNumbers = LottoNumber.validateLottoNumbers(input.split(","));
                lotto = new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            return lotto;
        }
    }

    private static int inputPurchaseAmount() {
        while (true) {
            LottoPurchaseAmount lottoPurchaseAmount;
            try {
                String input = Input.inputPurchaseAmount();
                lottoPurchaseAmount = new LottoPurchaseAmount(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            return lottoPurchaseAmount.getPurchaseAmount();
        }
    }
}
