package lotto.constants;
public enum AppConstants {
    RANDOM_RANGE_BEGIN("1"),
    RANDOM_RANGE_END("45"),
    LOTTO_LENGTH("6"),
    LOTTO_TICKET_PRICE("1000"),
    INPUT_DELIMITER(",");


    private final String constants;

    AppConstants(String str) {
        this.constants =  str;
    }
}