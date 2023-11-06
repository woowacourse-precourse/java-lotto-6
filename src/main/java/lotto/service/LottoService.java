package lotto.service;

public class LottoService {

    private static final int LOTTO_TICKET_PRICE = 1000;
    private static final String FIRST_ERROR_MESSAGE = "[ERROR] ";
    private static final String PURCHASE_AMOUNT_DIVIDE_EXCEPTION_MESSAGE = "로또 구입 금액은 1,000원으로 나누어 떨어져야합니다.";
    private static final String PURCHASE_AMOUNT_NOT_DIGIT_EXCEPTION_MESSAGE = "로또 구입 금액은 숫자여야합니다.";

    public int calculateNumberOfLottoTickets(String purchaseAmount) {
        validateLottoPurchaseAmount(purchaseAmount);
        return Integer.parseInt(purchaseAmount) / LOTTO_TICKET_PRICE;
    }

    public void validateLottoPurchaseAmount(String lottoPurchaseAmount) {

        if (PurchaseAmountNOTDivideBy1000(lottoPurchaseAmount)) {
            throw new IllegalArgumentException(FIRST_ERROR_MESSAGE + PURCHASE_AMOUNT_DIVIDE_EXCEPTION_MESSAGE);
        }

        if (PurchaseAmountNotDigit(lottoPurchaseAmount)) {
            throw new IllegalArgumentException(FIRST_ERROR_MESSAGE + PURCHASE_AMOUNT_NOT_DIGIT_EXCEPTION_MESSAGE);
        }
    }

    private boolean PurchaseAmountNOTDivideBy1000(String lottoPurchaseAmount) {
        int amount = Integer.parseInt(lottoPurchaseAmount);
        return amount % LOTTO_TICKET_PRICE != 0;
    }

    private boolean PurchaseAmountNotDigit(String lottoPurchaseAmount) {
        try {
            Integer.parseInt(lottoPurchaseAmount);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

}