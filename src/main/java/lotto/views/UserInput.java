package lotto.views;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.utils.StringUtils.getIntegerValue;
import static lotto.utils.StringUtils.validContainsWhiteSpace;
import static lotto.utils.StringUtils.validEmptyString;
import static lotto.validators.PurchaseValidator.validPurchasePrice;

public class UserInput {
    public static Integer readPurchasePrice() {
        while (true) {
            try {
                String inputLottoPurchasePrice = readLine();
                validEmptyString(inputLottoPurchasePrice);
                validContainsWhiteSpace(inputLottoPurchasePrice);

                Integer purchasePrice = getIntegerValue(inputLottoPurchasePrice);
                validPurchasePrice(purchasePrice);

                return purchasePrice;
            } catch (IllegalArgumentException e) {
                ErrorOutput.printErrorMessage(e.getMessage());
            }
        }
    }
}
