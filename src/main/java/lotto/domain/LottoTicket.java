package lotto.domain;

import lotto.constant.ExceptionMessage;
import lotto.constant.LottoConstant;

public record LottoTicket(int amount) {

    public LottoTicket {
        validateTicketPositive(amount);
    }

    public static LottoTicket buyTicket(String input) {
        int price = validatePriceInteger(input);
        validatePricePositive(price);
        validatePriceDivisible(price);
        return new LottoTicket(price / LottoConstant.LOTTO_PRICE);
    }

    private static void validateTicketPositive(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_TICKET_AMOUNT);
        }
    }

    private static int validatePriceInteger(String price) {
        try {
            return Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BUYING_PRICE);
        }
    }

    private static void validatePricePositive(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.NEGATIVE_BUYING_PRICE);
        }
    }

    private static void validatePriceDivisible(int price) {
        if (price % LottoConstant.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.BUYING_PRICE_NOT_DIVISIBLE);
        }
    }
}
