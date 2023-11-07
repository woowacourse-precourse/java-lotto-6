package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;
import java.util.List;
import lotto.data.WinningCombination;
import lotto.message.ErrorMessage;
import lotto.message.OutputMessage;
import lotto.utils.LottoUtil;
import lotto.utils.Util;

public class LottoPurchaseInput {
    public static BigDecimal inputPurchaseAmount(BigDecimal lottoPrice) {
        try {
            OutputMessage.ASK_PURCHASE_AMOUNT.printMessage();
            String input = Console.readLine().trim();

            validate(input);
            Util.validateNumber(input);
            LottoUtil.validatePurchaseAmount(new BigDecimal(input), lottoPrice);

            return new BigDecimal(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPurchaseAmount(lottoPrice);
        }
    }

    public static WinningCombination inputWinningNumbers() {
        try {
            OutputMessage.ASK_WINNING_LOTTO_NUMBER.printMessage();
            String inputNumbers = Console.readLine().trim();
            validate(inputNumbers);

            OutputMessage.ASK_BONUS_NUMBER.printMessage();
            String inputBonusNumber = Console.readLine().trim();
            validate(inputBonusNumber);
            Util.validateInteger(inputBonusNumber);

            List<Integer> numbers = Util.convertToIntegerList(inputNumbers, ",");
            return new WinningCombination(numbers, Integer.parseInt(inputBonusNumber));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNumbers();
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
