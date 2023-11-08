package lotto.constants;
import static lotto.constants.LottoNumberConstants.*;
public enum ErrorMassageConstants {
    CONVERT_ADDITION_NUMBER_ERROR_MESSAGE ("[ERROR] : The provided addition number is not valid integers: "),
    ADDITION_NUMBER_IN_RANGE_ERROR_MESSAGE ("[ERROR] : The addition number must be in the range of " + MIN_LOTTO_NUMBER + " to " + MAX_LOTTO_NUMBER + "."),
    ADDITION_NUMBER_DUPLICATE_ERROR_MESSAGE ("[ERROR] : The addition number should not duplicate any of the main winning numbers."),
    ADDITION_NUMBER_SIZE_OVER_ERROR_MESSAGE("[ERROR] : The number of additional number size cannot exceed 1."),
    CONVERT_PURCHASE_AMOUNT_ERROR_MESSAGE("[ERROR] : The provided lotto purchase amount is not a valid integer: "),
    AMOUNT_IS_A_THOUSAND_UNITS_ERROR_MESSAGE("[ERROR] : The provided amount is not a multiple of 1000: "),
    AMOUNT_LEAST_ONE_LOTTO_PRICE_ERROR_MESSAGE("[ERROR] : The provided amount is less than the minimum lotto purchase amount: "),
    CONVERT_LOTTO_WINNING_NUMBER_ERROR_MESSAGE("[ERROR] : The provided winning numbers are not valid integers: "),
    WINNING_NUMBER_DUPLICATE_ERROR_MESSAGE("[ERROR] : The provided winning numbers contain duplicates."),
    WINNING_NUMBERS_IN_RANGE_ERROR_MESSAGE("[ERROR] : Lotto winning numbers must be in the range of " + MIN_LOTTO_NUMBER + " to " + MAX_LOTTO_NUMBER + "."),
    WINNING_NUMBER_SIZE_OVER_ERROR_MESSAGE("[ERROR] : The size of winning numbers must be exactly " + LOTTO_NUMBER_RANGE + "."),
    LOTTO_DUPLICATE_ERROR_MESSAGE("[ERROR] : The lotto numbers contain duplicates.");

    private final String message;

    ErrorMassageConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
