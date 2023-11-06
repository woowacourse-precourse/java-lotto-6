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
    }

    private static Lotto inputWinningNumbers() {
        Lotto lotto = null;
        try {
            String input = Input.inputWinningNumbers();
            List<Integer> winningNumbers = LottoNumber.validateLottoNumbers(input.split(","));
            lotto = new Lotto(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputWinningNumbers();
        }
        return lotto;
    }

    private static int inputPurchaseAmount() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount();
        try {
            String input = Input.inputPurchaseAmount();
            lottoPurchaseAmount = new LottoPurchaseAmount(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputPurchaseAmount();
        }
        return lottoPurchaseAmount.getPurchaseAmount();
    }
}
