package lotto.validator;

public class UserTicketValidator {

    private UserTicketValidator() {
    }

    /**
     * 유저의 가격 입력정보 검증
     * - 입력받은 가격정보가 정수인지.
     * - 가격이 1000원의 배수인지.
     * - 구매 갯수가 0 이상의 정수인지
     */

    public static void validateTicketPrice(String price) {
        validateTicketPriceInteger(price);
        validateTicketPriceIsMultiple(price);
        validateTicketPriceCount(price);
    }

    public static void validateTicketPriceInteger(String price) {
        try {
            Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("가격정보는 정수만 입력될 수 있습니다.");
        }
    }

    private static void validateTicketPriceIsMultiple(String input) {
        int price = Integer.parseInt(input);
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("가격 정보는 1000의 배수여야 합니다.");
        }
    }

    private static void validateTicketPriceCount(String input) {
        int price = Integer.parseInt(input);
        if (price / 1000 <= 0) {
            throw new IllegalArgumentException("로또는 1개 이상구매해야합니다.");
        }
    }

}
