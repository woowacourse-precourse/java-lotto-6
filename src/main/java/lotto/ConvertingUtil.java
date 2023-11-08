package lotto;

public class ConvertingUtil {
    private static final Integer TICKET_PRICE = 1000;

    public static int convertToTicket(String userInput) {
        return convertToInteger(userInput) / TICKET_PRICE;
    }

    public static int convertToInteger(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 이외의 값은 입력할 수 없습니다.");
        }
    }
}
