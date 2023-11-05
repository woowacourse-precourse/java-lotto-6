package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.constants.ErrorMessage;
import lotto.constants.InputMessage;
import lotto.model.Bonus;
import lotto.model.InputValidation;
import lotto.model.Lotto;
import lotto.model.Purchase;

public class InputView {
    public static int getUserPurchaseAmount() {
        while (true) {
            try {
                System.out.println(InputMessage.PURCHASE_AMOUNT.getMessage());
                String input = Console.readLine();
                int purchaseAmount = InputValidation.validatePurchaseAmount(input);
                Purchase purchase = new Purchase(purchaseAmount);
                return purchase.getPurchase();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> getWinningNumbers() {
        List<Integer> lottoNumbers;
        while (true) {
            try {
                System.out.println(InputMessage.LOTTO_NUMBERS.getMessage());
                String[] numbers = Console.readLine().split(",");
                lottoNumbers = new ArrayList<>();

                for (int i = 0; i < numbers.length; i++) {
                    try {
                        int number = Integer.parseInt(numbers[i]);
                        lottoNumbers.add(number);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException(ErrorMessage.INVALID_NON_NUMERIC.getMessage());
                    }
                }
                Lotto lotto = new Lotto(lottoNumbers);
                return lotto.getWinningNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getBonusNumber(List<Integer> winningNumbers) {
        System.out.println();
        while (true) {
            try {
                System.out.println(InputMessage.BONUS_NUMBER.getMessage());
                String input = Console.readLine();
                int bonusNumber = InputValidation.validateBonusNumber(input);
                Bonus bonus = new Bonus(bonusNumber, winningNumbers);
                return bonus.getBonusNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
