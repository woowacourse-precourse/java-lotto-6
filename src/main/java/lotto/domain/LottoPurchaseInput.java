package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;
import java.util.List;
import lotto.data.Amount;
import lotto.data.Lotto;
import lotto.message.ErrorMessage;
import lotto.message.OutputMessage;
import lotto.utils.Util;

public class LottoPurchaseInput {
    public static Amount inputPurchaseAmount(BigDecimal lottoPrice) {
        try {
            OutputMessage.ASK_PURCHASE_AMOUNT.printMessage();
            String input = Console.readLine().trim();

            validate(input);
            Util.validateNumber(input);

            return new Amount(input, lottoPrice);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPurchaseAmount(lottoPrice);
        }
    }

    public static List<Integer> inputWinningNumbers() {
        try {
            OutputMessage.ASK_WINNING_LOTTO_NUMBER.printMessage();
            String inputNumbers = Console.readLine().trim();

            validate(inputNumbers);
            List<Integer> numbers = Util.convertToIntegerList(inputNumbers, ",");
            Lotto.validate(numbers);

            return numbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNumbers();
        }
    }

    public static int inputBonusNumber() {
        try {
            OutputMessage.ASK_BONUS_NUMBER.printMessage();
            String inputBonusNumber = Console.readLine().trim();

            validate(inputBonusNumber);
            Util.validateInteger(inputBonusNumber);

            return Integer.parseInt(inputBonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber();
        }
    }

    private static void validate(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_CONTAINS_WHITE_CHAR.getMessage());
        }
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_EMPTY.getMessage());
        }
    }
}
