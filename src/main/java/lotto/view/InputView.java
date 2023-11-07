package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.exception.ErrorCode;
import lotto.exception.LottoGameException;

public class InputView {
    public static int readPurchaseAmount() {
        String inputPurchaseAmount = Console.readLine();
        return convertInputPurchaseAmountToInt(inputPurchaseAmount);
    }

    public static List<Integer> readMainWinningNumbers() {
        String inputMainWinningNumbers = Console.readLine();
        return convertInputMainWinningNumbersToIntegerList(inputMainWinningNumbers);
    }

    private static List<Integer> convertInputMainWinningNumbersToIntegerList(String inputMainWinningNumbers) {
        try {
            return Stream.of(inputMainWinningNumbers.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException exception) {
            throw new LottoGameException(ErrorCode.NON_INT_WINNING_NUMBER);
        }
    }

    private static int convertInputPurchaseAmountToInt(String inputPurchaseAmount) {
        try {
            return Integer.parseInt(inputPurchaseAmount);
        } catch (NumberFormatException exception) {
            throw new LottoGameException(ErrorCode.NON_INT_PURCHASE_AMOUNT);
        }
    }
}
