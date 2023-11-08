package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.util.Converter;

import java.util.List;

import static lotto.util.Validator.*;

public class Input {
    public static int readTotalPurchasedAmount() {
        String amountStr = Console.readLine();
        validateDigit(amountStr);
        int amount = Integer.parseInt(amountStr);
        validateOverZero(amount);
        validateAmountInThousands(amount);
        return amount;
    }

    public static Lotto readWinningNumbers() {
        String numberStr = Console.readLine();
        List<Integer> winningNumbers = Converter.stringToIntegerList(numberStr, ",");
        return new Lotto(winningNumbers);
    }

    public static int readBonusNumber() {
        String numberStr = Console.readLine();
        validateDigit(numberStr.trim());
        return Integer.parseInt(numberStr.trim());
    }
}
