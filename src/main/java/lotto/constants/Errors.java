package lotto.constants;

public class Errors {
    public static final String ERROR = "[ERROR]";
    public static final String COST_NUMERIC = ERROR + " 구입 금액은 숫자여야 합니다.";
    public static final String COST_THOUSANDS = ERROR + " 구입 금액은 "
            + Constants.LOTTO_PRICE + "의 배수여야 합니다.";
    public static final String ANSWER_NUMERIC = ERROR + " 로또 번호는 숫자여야 합니다.";
    public static final String ANSWER_RANGE = ERROR + " 로또 번호는 "
            + Constants.START + "부터 " + Constants.END + " 사이의 숫자여야 합니다.";
    public static final String ANSWER_DUPLICATE = ERROR + " 로또 번호에 중복된 숫자가 있으면 안됩니다.";
    public static final String ANSWER_NUMBERS = ERROR + " 로또 번호는 "
            + Constants.NUMBER_COUNT + "개여야 합니다.";
    public static final String BONUS_NUMERIC = ERROR + " 보너스 번호는 숫자여야 합니다.";
    public static final String BONUS_RANGE = ERROR + " 보너스 번호는 "
            + Constants.START + "부터 " + Constants.END + " 사이의 숫자여야 합니다.";
    public static final String BONUS_DUPLICATE = ERROR + " 보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    private Errors() {
    }
}
