package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Converter;

import java.util.List;

import static lotto.util.Validator.*;

public class Input {
    public int readTotalPurchasedAmount() {
        String amountStr = Console.readLine();
        validateDigit(amountStr);
        int amount = Integer.parseInt(amountStr);
        validateAmountInThousands(amount);
        return amount;
    }

    public List<Integer> readWinningNumbers() {
        String numberStr = Console.readLine();
        List<Integer> winningNumbers = Converter.stringToIntegerList(numberStr, ",");
        validateNumberOfLottoNumbers(winningNumbers);
        return winningNumbers;
    }
}
