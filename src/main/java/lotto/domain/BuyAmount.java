package lotto.domain;

public class BuyAmount {
    private static final int ZERO = 0;
    private static final int LOTTO_PRICE = 1000;
    private static final String COMMA = ",";
    private static final String NULL = "";
    private final int payment;
    private final int numberOfLottos;

    public BuyAmount(String payment) {
        payment = removeSeparatorChar(payment);
        validate(payment);
        this.payment = convertStringToInt(payment);
        this.numberOfLottos = calculateNumberOfBuyAmount(this.payment);
    }

    public int getPayment() {
        return payment;
    }

    public int getNumberOfLottos() {
        return numberOfLottos;
    }

    private void validate(String amount) {
        if (isStringEmpty(amount) || !isStringDigit(amount)) {
            ExceptionMessage.PURCHASE_AMOUNT_IS_NOT_NUMBER.throwException();
        } else if (!isExceedZero(amount)) {
            ExceptionMessage.PURCHASE_AMOUNT_IS_NOT_EXCEED_ZERO.throwException();
        } else if (!isThousandUnits(amount)) {
            ExceptionMessage.PURCHASE_AMOUNT_IS_NOT_THOUSAND_UNITS.throwException();
        }
    }

    private boolean isStringEmpty(String amount) {
        return amount == null || amount.isBlank();
    }

    private boolean isStringDigit(String amount) {
        return amount.chars().allMatch(Character::isDigit);
    }

    private boolean isExceedZero(String amount) {
        return convertStringToInt(amount) > ZERO;
    }

    private boolean isThousandUnits(String amount) {
        return convertStringToInt(amount) % LOTTO_PRICE == ZERO;
    }

    private int convertStringToInt(String amount) {
        return Integer.parseInt(amount);
    }

    private String removeSeparatorChar(String amount) {
        return amount.replaceAll(COMMA, NULL);
    }

    private int calculateNumberOfBuyAmount(int amount) {
        return amount / LOTTO_PRICE;
    }
}
