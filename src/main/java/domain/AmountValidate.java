package domain;

public class AmountValidate {

    public void validateAmount(String amount) {
        validateNumberFormat(amount);
        validateAmountUnder(amount);
        validateAmountUnit(amount);
    }

    private void validateNumberFormat(String amount) {
        if (!amount.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorConstants.INPUT_ONLY_NUMBER.getMessage());
        }
    }

    private void validateAmountUnder(String amount) {
        if (Integer.parseInt(amount) < 1000) {
            throw new IllegalArgumentException(ErrorConstants.INPUT_OVER_1000.getMessage());
        }
    }

    private void validateAmountUnit(String amount) {
        if (Integer.parseInt(amount) % 1000 != 0) {
            throw new IllegalArgumentException(ErrorConstants.INPUT_UNIT_1000.getMessage());
        }
    }
}

