package lotto.model;


public class LottoTicket {

//    private static final String ERROR_NULL_OR_EMPTY = "구입금액을 입력해 주세요.";
//    private static final String ERROR_CHECK_INPUT_TYPE = "유효하지 않은 금액입니다. 숫자를 입력해주세요.";
//    private static final String ERROR_LESS_THAN_MINIMUM = "구입 금액은 0보다 커야 합니다.";
//    private static final String ERROR_NOT_MULTIPLE_OF_THOUSAND = "구입 금액은 1000원 단위로 입력해야 합니다.";

    private static final String ERROR_NULL_OR_EMPTY = "NULL_OR_EMPTY";
    private static final String ERROR_CHECK_INPUT_TYPE = "CHECK_INPUT_TYPE";
    private static final String ERROR_LESS_THAN_MINIMUM = "LESS_THAN_MINIMUM";
    private static final String ERROR_NOT_MULTIPLE_OF_THOUSAND = "NOT_MULTIPLE_OF_THOUSAND";
    private final int ticketCount;

    public LottoTicket(String money) {
        int parsedMoney = parseAndValidateMoney(money);
        this.ticketCount = calculateTicketCount(parsedMoney);
    }

    public int getTicketCount() {
        return ticketCount;
    }

    private static int parseAndValidateMoney(String money) {
        validateNotNullOrEmpty(money);
        return validMoneyTypeCheck(money);
    }

    private static void validateNotNullOrEmpty(String money) {
        if (money == null || money.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_NULL_OR_EMPTY);
        }
    }

    private static int validMoneyTypeCheck(String money) {
        try {
            int parsedMoney = Integer.parseInt(money);
            validateMoneyAmount(parsedMoney);
            return parsedMoney;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_CHECK_INPUT_TYPE);
        }
    }

    private static void validateMoneyAmount(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException(ERROR_LESS_THAN_MINIMUM);
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_NOT_MULTIPLE_OF_THOUSAND);
        }
    }

    private static int calculateTicketCount(int money) {
        return money / 1000;
    }
}