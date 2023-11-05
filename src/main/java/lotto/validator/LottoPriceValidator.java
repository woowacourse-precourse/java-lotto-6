package lotto.validator;

public class LottoPriceValidator {

    private static final int LOTTO_ONE_PRICE = 1000;

    public static void validate(Object input) {
        String inputStr = (String) input;
        validateLottoPriceNotNumber(inputStr);
        validateLottoPriceNotDivided(inputStr);
    }

    private static void validateLottoPriceNotNumber(String input) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private static void validateLottoPriceNotDivided(String input) throws IllegalArgumentException {
        if (Integer.parseInt(input) % LOTTO_ONE_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR} 구매 금액은 1000원 단위로 작성되어야 합니다.");
        }
    }

}

