package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.constants.ErrorMessage;
import lotto.constants.InputMessage;
import lotto.model.Lotto;

public class InputView {
    public static int getUserPurchaseAmount() {
        int purchaseAmount;

        while (true) {
            try {
                System.out.println(InputMessage.PURCHASE_AMOUNT.getMessage());
                String input = Console.readLine();

                if (!input.matches("[1-9]\\d*")) {
                    if (input.matches("[-]\\d+")) {
                        throw new IllegalArgumentException(ErrorMessage.INVALID_NEGATIVE_PURCHASE.getMessage());
                    }
                    if (input.matches("0+")) {
                        throw new IllegalArgumentException(ErrorMessage.INVALID_ZERO_PURCHASE.getMessage());
                    }
                    throw new IllegalArgumentException(ErrorMessage.INVALID_NON_NUMERIC_PURCHASE.getMessage());
                }

                purchaseAmount = Integer.parseInt(input);

                if (purchaseAmount % 1000 != 0) {
                    throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_NOT_DIVISIBLE.getMessage());
                }

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return purchaseAmount;
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
                return lotto.getNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getBonusNumber(List<Integer> lottoNumbers) {
        System.out.println();
        int bonusNumber;
        while (true) {
            try {
                System.out.println(InputMessage.BONUS_NUMBER.getMessage());
                String input = Console.readLine();

                try {
                    bonusNumber = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException(ErrorMessage.INVALID_NON_NUMERIC_PURCHASE.getMessage());
                }

                if (bonusNumber < 1 || bonusNumber > 45) {
                    throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage());
                }

                if (lottoNumbers.contains(bonusNumber)) {
                    throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_DUPLICATE.getMessage());
                }

                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
