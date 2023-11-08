package lotto;

public class Amount {
    private static final int AMOUNT_LIMIT = 100000;
    private static final int NO_CHANGES = 0;

    private final int value;

    Amount(String value){
        validateNumberFormat(value);
        this.value = Integer.parseInt(value);
        validateAmountUnit(this.value);
        validateAmountLimit(this.value);
    }

    private void validateNumberFormat(String value){

        try {
            Integer.parseInt(value);
        }catch (NumberFormatException numberFormatException){
            throw new IllegalArgumentException(ErrorMessage.NO_NUMBER_FORMAT);
        }
    }

    private void validateAmountUnit(int amount) {
        int changes = amount % Lotto.PRICE;
        if (changes != NO_CHANGES) {
            throw new IllegalArgumentException(String.format(ErrorMessage.GENERATE_CHANGES_FORMAT, Lotto.PRICE));
        }
    }

    private void validateAmountLimit(int amount) {
        if (amount > AMOUNT_LIMIT) {
            throw new IllegalArgumentException(String.format(ErrorMessage.MAXIMUM_PURCHASE_AMOUNT_FORMAT, AMOUNT_LIMIT));
        }
    }

    public int getValue(){
        return this.value;
    }
}
