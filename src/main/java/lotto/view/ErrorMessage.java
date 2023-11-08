package lotto.view;

public enum ErrorMessage {

    INPUT_FORMAT_ERROR("[ERROR] 숫자를 입력해주세요."),
    MONEY_FORMAT_ERROR("[ERROR] 1000원 단위로 입력해주세요."),
    LOTTO_DISTINCT_NUMBERS_ERROR("[ERROR] 숫자 중복 없이 입력해주세요."),
    LOTTO_NUMBER_RANGE_ERROR("[ERROR] 1 ~ 45 사이 숫자를 입력해주세요."),
    LOTTO_NUMBERS_SIZE_ERROR("[ERROR] 숫자 6개를 입력해주세요."),
    BONUS_NUMBER_RANGE_ERROR("[ERROR] 1 ~ 45 사이 숫자를 입력해주세요."),
    BONUS_NUMBER_DISTINCT_ERROR("[ERROR] 당첨 번호와 중복 없이 입력해주세요.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public static void printInputFormatError() {
        System.out.println(INPUT_FORMAT_ERROR.getMessage());
    }

    public static void printMoneyFormatError() {
        System.out.println(MONEY_FORMAT_ERROR.getMessage());
    }

    public static void printLottoDistinctNumberError() {
        System.out.println(LOTTO_DISTINCT_NUMBERS_ERROR.getMessage());
    }

    public static void printLottoNumberRangeError() {
        System.out.println(LOTTO_NUMBER_RANGE_ERROR.getMessage());
    }

    public static void printLottoNumbersSizeError() {
        System.out.println(LOTTO_NUMBERS_SIZE_ERROR.getMessage());
    }

    public static void printBonusNumberRangeError() {
        System.out.println(BONUS_NUMBER_RANGE_ERROR.getMessage());
    }

    public static void printBonusNumberDistinctError() {
        System.out.println(BONUS_NUMBER_DISTINCT_ERROR.getMessage());
    }

    private String getMessage() {
        return message;
    }
}
