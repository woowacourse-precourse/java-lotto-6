package lotto.views;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.utils.StringUtils.getIntegerValue;
import static lotto.utils.StringUtils.getIntegerValueList;
import static lotto.utils.StringUtils.validContainsWhiteSpace;
import static lotto.utils.StringUtils.validEmptyString;
import static lotto.validators.PurchaseValidator.validPurchasePrice;
import static lotto.validators.WinningNumberValidator.validWinningNumberCount;
import static lotto.validators.WinningNumberValidator.validWinningNumberDuplicated;
import static lotto.validators.WinningNumberValidator.validWinningNumberValueInRange;

import java.util.List;

public class UserInput {
    public static Integer readPurchasePrice() {
        while (true) {
            try {
                return inputLottoPurchasePrice();
            } catch (IllegalArgumentException e) {
                ErrorOutput.printErrorMessage(e.getMessage());
            }
        }
    }

    public static List<Integer> readWinningNumber() {
        while (true) {
            try {
                return inputWinningNumber();
            } catch (IllegalArgumentException e) {
                ErrorOutput.printErrorMessage(e.getMessage());
            }
        }
    }

    private static Integer inputLottoPurchasePrice() {
        String inputLottoPurchasePrice = readLine();
        validEmptyString(inputLottoPurchasePrice);
        validContainsWhiteSpace(inputLottoPurchasePrice);

        Integer purchasePrice = getIntegerValue(inputLottoPurchasePrice);
        validPurchasePrice(purchasePrice);

        return purchasePrice;
    }

    private static List<Integer> inputWinningNumber() {
        String inputLottoWinningNumber = readLine();
        validEmptyString(inputLottoWinningNumber);
        validContainsWhiteSpace(inputLottoWinningNumber);

        String[] split = inputLottoWinningNumber.split(",");
        validWinningNumberCount(split);

        List<Integer> winningNumbers = getIntegerValueList(split);
        validWinningNumberValueInRange(winningNumbers);
        validWinningNumberDuplicated(winningNumbers);

        return winningNumbers;
    }
}
