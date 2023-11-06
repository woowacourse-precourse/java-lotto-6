package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;
import java.util.List;
import lotto.Lotto;
import lotto.message.ErrorMessage;
import lotto.message.OutputMessage;
import lotto.utils.LottoUtil;
import lotto.utils.Util;

public class LottoPurchaseInput {
    public static BigDecimal inputPurchaseAmount() {
        try {
            OutputMessage.ASK_PURCHASE_AMOUNT.printMessage();
            String input = Console.readLine().trim();

            validate(input);
            Util.validateNumber(input);
            return new BigDecimal(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPurchaseAmount();
        }
    }

    public static List<Integer> inputWinningNumbers() {
        try {
            OutputMessage.ASK_WINNING_LOTTO_NUMBER.printMessage();
            String input = Console.readLine().trim();

            validate(input);
            List<Integer> winningNumbers = Util.convertToIntegerList(input, ",");
            Lotto.validate(winningNumbers);

            return winningNumbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNumbers();
        }
    }

    public static int inputBonusNumber() {
        try {
            OutputMessage.ASK_BONUS_NUMBER.printMessage();
            String input = Console.readLine().trim();

            validate(input);
            Util.validateInteger(input);
            int bonusNumber = Integer.parseInt(input);
            LottoUtil.validateLottoNum(bonusNumber);

            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber();
        }
    }

        if (input.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_CONTAINS_WHITE_CHAR.getMessage());
        }
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_EMPTY.getMessage());
        }
    }
}
