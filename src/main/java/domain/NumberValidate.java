package domain;

public class NumberValidate {

    public void validateAmount(String amount) {
        validateNumberFormat(amount);
        validateAmountUnder(amount);
        validateAmountUnit(amount);
    }

    public void validateBonusNumber(String bonusNumber) {
        validateNumberFormat(bonusNumber);
        validateBonusUnit(bonusNumber);
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

    private void validateBonusUnit(String amount) {
        int parsedAmount = Integer.parseInt(amount);
        if (parsedAmount < 1 || parsedAmount > 10) {
            throw new IllegalArgumentException(ErrorConstants.INPUT_UNDER_10.getMessage());
        }
    }
}

