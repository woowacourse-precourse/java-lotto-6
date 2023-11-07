package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.Lotto;
import lotto.LottoNumber;
import lotto.LottoPurchaseAmount;

public class Input {

    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static int getBonusNumber(Lotto winningNumbers) {
        while (true) {
            int bonusNumber;
            try {
                String input = inputBonusNumber();
                bonusNumber = LottoNumber.validateLottoNumber(input);
                winningNumbers.isBonusNumberDuplicate(bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            return bonusNumber;
        }
    }

    public static Lotto getWinningNumbers() {
        while (true) {
            Lotto lotto;
            try {
                String input = inputWinningNumbers();
                List<Integer> winningNumbers = LottoNumber.validateLottoNumbers(input.split(","));
                lotto = new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            return lotto;
        }
    }

    public static int getPurchaseAmount() {
        while (true) {
            LottoPurchaseAmount lottoPurchaseAmount;
            try {
                String input = inputPurchaseAmount();
                lottoPurchaseAmount = new LottoPurchaseAmount(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            return lottoPurchaseAmount.getPurchaseAmount();
        }
    }

    private static String inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    private static String inputWinningNumbers() {
        System.out.println("\n" + INPUT_WINNING_NUMBERS);
        return Console.readLine();
    }

    private static String inputBonusNumber() {
        System.out.println("\n" + INPUT_BONUS_NUMBER);
        return Console.readLine();
    }
}
