package lotto.messages;

public class ErrorMessages {

    private static final String ERROR = "[ERROR] ";
    public static final String TYPE_MISS_MATCHING = ERROR + "Type miss matching";

    //== Lotto Number ERROR ==// LOTTO
    public static final String LOTTO_NUMBER_SIZE = ERROR + "6개의 숫자를 골라주세요.";
    public static final String LOTTO_NUMBER_DUPLICATION = ERROR + "중복되지 않는 숫자를 골라주세요.";
    public static final String LOTTO_NUMBER_RANGE = ERROR + "1 ~ 45 사이의 숫자를 골라주세요.";

    //== Bonus Number ==//
    public static final String DUPLICATION_WITH_WINNING_NUMBER = ERROR + "당첨번호와 중복 될 수 없습니다.";
    public static final String BONUS_NUMBER_RANGE = ERROR + "1 ~ 45 사이의 숫자를 골라주세요.";

    //== Purchase Amount ==//
    public static final String INCORRECT_PURCHASE_AMOUNT = ERROR + "구입금액은 1,000원 단위로 입력해주세요";
}
