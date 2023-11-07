package lotto.model;

import static lotto.util.Constant.LOTTO_PER_PRICE;

import java.util.regex.Pattern;

public class LottoPurchase {
    private static final Pattern REGEX_NUMERIC = Pattern.compile("^[0-9]\\d*$");

    private int lottoPurchaseCount;

    private int getLottoPurchaseCount(int totalPrice) {
        return totalPrice / LOTTO_PER_PRICE;
    }

    private void setLottoPurchaseCount(String inputNumber) {
        int totalPrice = Integer.parseInt(inputNumber);
        this.lottoPurchaseCount = getLottoPurchaseCount(totalPrice);
    }

    private void validateInputTypeNumeric(String inputNumber) {
        if (!REGEX_NUMERIC.matcher(inputNumber).matches()) {
            throw new IllegalArgumentException("ERROR_NUMERIC_TYPE");
        }
    }
}