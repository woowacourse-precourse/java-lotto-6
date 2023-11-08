package lotto.domain;

public class PurchaseAmount {
    private static final int ZERO = 0;
    private static final int LOTTO_PRICE = 1000;
    private static final String COMMA = ",";
    private static final String NULL_SPACE = "";
    private final int amount;
    private final int numberOfLottoPurchased;
    private static final String PURCHASE_AMOUNT_IS_NOT_NUMBER = "[ERROR] 금액을 투입해 주셔야 합니다.";
    private static final String PURCHASE_AMOUNT_IS_NOT_EXCEED_ZERO = "[ERROR] 0을 초과한 금액을 투입해 주셔야 합니다.";
    private static final String PURCHASE_AMOUNT_IS_NOT_THOUSAND_UNITS = "[ERROR] 입력 금액은 1,000원 단위여야 합니다.";

    public PurchaseAmount(String amount) {
        amount = removeComma(amount);
        validateOption(amount);
        this.amount = convertStringToInt(amount);
        this.numberOfLottoPurchased = calculateNumberOfLottoByAmount(this.amount);
    }

    public int getAmount() {
        return amount;
    }

    public int getNumberOfLottoPurchased() {
        return numberOfLottoPurchased;
    }

    private boolean isStringEmpty(String amount){
        return amount == null || amount.isBlank();
    }

    private boolean isStringDigit(String amount){
        return amount.chars().allMatch(Character :: isDigit);
    }

    private boolean isExceedZero(String amount){
        return convertStringToInt(amount)>ZERO;
    }

    private boolean isDivideThousand(String amount){
        return convertStringToInt(amount) % LOTTO_PRICE == ZERO;
    }

    private String removeComma(String amount){
        return amount.replace(COMMA,NULL_SPACE);
    }

    private void validateOption(String amount){
        if (isStringEmpty(amount) || !isStringDigit(amount)){
            throw new IllegalArgumentException(PURCHASE_AMOUNT_IS_NOT_NUMBER);
        } else if (!isExceedZero(amount)) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_IS_NOT_EXCEED_ZERO);
        } else if (!isDivideThousand(amount)) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_IS_NOT_THOUSAND_UNITS);
        }
    }

    private int convertStringToInt(String amount){
        return Integer.parseInt(amount);
    }

    private int calculateNumberOfLottoByAmount(int amount){
        return amount/LOTTO_PRICE;
    }
}
