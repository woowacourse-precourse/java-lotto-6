package lotto.model;

import static lotto.util.Constant.LOTTO_PER_PRICE;
import static lotto.util.Constant.REGEX_NUMERIC;
import static lotto.util.ErrorMessage.ERROR_MINIMUM_PRICE;
import static lotto.util.ErrorMessage.ERROR_NOT_DIVIDE_LOTTO_PRICE;
import static lotto.util.ErrorMessage.ERROR_NUMERIC_TYPE;

public class LottoPurchase {
    private int lottoPurchaseCount;

    public LottoPurchase(String inputNumber) {
        setLottoPurchaseCount(inputNumber);
    }

    private static void validateInputTypeNumeric(String inputNumber) {
        if (!REGEX_NUMERIC.matcher(inputNumber).matches()) {
            throw new IllegalArgumentException(ERROR_NUMERIC_TYPE);
        }
    }

    private static void validateMinimunPrice(int totalPrice) {
        if (totalPrice < LOTTO_PER_PRICE) {
            throw new IllegalArgumentException(ERROR_MINIMUM_PRICE);
        }
    }

    private static void validateDivideLottoPrice(int totalPrice) {
        if ((totalPrice % LOTTO_PER_PRICE) != 0) {
            throw new IllegalArgumentException(ERROR_NOT_DIVIDE_LOTTO_PRICE);
        }
    }

    private int getLottoPurchaseCount(int totalPrice) {
        return totalPrice / LOTTO_PER_PRICE;
    }

    private void setLottoPurchaseCount(String inputNumber) {
        validateInputTypeNumeric(inputNumber);
        int totalPrice = Integer.parseInt(inputNumber);
        validateMinimunPrice(totalPrice);
        validateDivideLottoPrice(totalPrice);
        this.lottoPurchaseCount = getLottoPurchaseCount(totalPrice);
    }

    public int getLottoCount() {
        return lottoPurchaseCount;
    }
}