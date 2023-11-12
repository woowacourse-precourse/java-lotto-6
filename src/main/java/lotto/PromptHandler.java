package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PromptHandler {
    public static int inputPurchaseAmount() {
        try {
            System.out.println(LottoMessage.ASK_PURCHASE_AMOUNT.getMessage());
            String purchaseAmount = Console.readLine();

            return Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_AMOUNT.getMessage());
        }
    }

    public static List<Integer> inputWinningNumbers() {
        try {
            System.out.println(LottoMessage.ASK_WINNING_NUMBER.getMessage());
            String[] numbers = Console.readLine().split(LottoMessage.DELIMITER.getMessage());

            return Arrays.stream(numbers).map(Integer::parseInt).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_WINNING_NUMBER.getMessage());
        }
    }

    public static Integer inputBonusNumber() {
        try {
            System.out.println(LottoMessage.ASK_BONUS_NUMBER.getMessage());
            String bonusNumber = Console.readLine();

            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_BONUS_NUMBER.getMessage());
        }
    }
}
