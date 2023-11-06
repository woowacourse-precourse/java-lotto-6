package lotto.domain;

public class PrintMessage {

    private PrintMessage() {
    }

    public static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBER = "\n당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";
    public static final String ONLY_DIGIT = "[ERROR] 숫자를 입력해주세요.";
    public static final String ONLY_THOUSAND_UNIT = "[ERROR] 1000원 단위로 입력해주세요.";
    public static final String ONLY_SPLIT_COMMA = "[ERROR] 번호를 쉼표(,)로 나누어야 합니다.";
    public static final String BETWEEN_ONE_AND_FORTYFIVE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String NOT_DUPLICATION = "[ERROR] 중복되지 않는 번호로 입력해주세요.";
    public static final String ONLY_SIX_NUMBER = "[ERROR] 당첨 번호는 6개여야 합니다.";
    public static final String PRINT_NUMBER_OF_PURCHASES = "개를 구매했습니다.";
}
