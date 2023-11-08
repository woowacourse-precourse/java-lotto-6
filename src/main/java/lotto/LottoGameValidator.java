package lotto;

public class LottoGameValidator {
    public static void validateInputAmount(String inputBuyAmount) {
        validateNumericInput(inputBuyAmount);
        validateBuyAmountFormat(inputBuyAmount);
    }

    private static void validateNumericInput(String inputBuyAmount) {
        try {
            int buyAmount = Integer.parseInt(inputBuyAmount);

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력하시오.");
        }
    }

    private static void validateBuyAmountFormat(String inputBuyAmount) {
        int buyAmount = Integer.parseInt(inputBuyAmount);

        if (buyAmount <= 0 || buyAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 0보다 큰 1000원 단위의 숫자로 입력해야 합니다");
        }
    }
}
