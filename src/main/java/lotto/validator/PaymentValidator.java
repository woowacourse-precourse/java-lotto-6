package lotto.validator;

public class PaymentValidator {
    private static final String PAYMENT_ERROR = "[ERROR] 구입금액은 1000의 배수여야 합니다.";
    private static final String TYPE_ERROR = "[ERROR] 구입금액은 정수이어야 합니다.";
    
    public static int validate(String payment) {
        int result = validateType(payment);
        return validatePrice(result);
    }

    private static int validateType(String input) {
        int result;
        try {
            result = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(TYPE_ERROR);
        }
        return result;
    }

    private static int validatePrice(int price) {
        if ((price % 1000) != 0 || price < 1000) {
            throw new IllegalArgumentException(PAYMENT_ERROR);
        }
        return price;
    }
}
