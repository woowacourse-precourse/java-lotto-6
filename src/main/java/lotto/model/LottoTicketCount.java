package lotto.model;


public class LottoTicketCount {

    private static final String ERROR_NULL_OR_EMPTY = "구입금액을 입력해 주세요.";
    private static final String ERROR_CHECK_INPUT_TYPE_OF_MONEY = "유효하지 않은 금액입니다. 숫자를 입력해주세요.";
    private static final String ERROR_LESS_THAN_MINIMUM = "구입 금액은 0보다 커야 합니다.";
    private static final String ERROR_NOT_MULTIPLE_OF_THOUSAND = "구입 금액은 1000원 단위로 입력해야 합니다.";

    private final int ticketCount;

    public LottoTicketCount(String money) {
        validateInput(money);
        int parsedMoney = parseMoney(money);
        validateMoneyCheck(parsedMoney);
        this.ticketCount = calculateTicketCount(parsedMoney);
    }
    public int getTicketCount() {
        return ticketCount;
    }

    private void validateInput(String money) {
        if (money == null || money.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_NULL_OR_EMPTY);
        }
    }
    private int parseMoney(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_CHECK_INPUT_TYPE_OF_MONEY);
        }
    }

    private void validateMoneyCheck(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException(ERROR_LESS_THAN_MINIMUM);
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_NOT_MULTIPLE_OF_THOUSAND);
        }
    }
    private int calculateTicketCount(int money) {
        return money / 1000;
    }
}