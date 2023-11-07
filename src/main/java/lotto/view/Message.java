package lotto.view;

import static lotto.view.Constants.LOTTO_PRICE;
import static lotto.view.Constants.NUM_OF_LOTTO;

public class Message {
    public static final String INPUT_LOTTO_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String TICKET_COUNT = "개를 구매했습니다.";
    public static final String WINNING_STATICS_MESSAGE = "당첨 통계";

    public static final String RANGE_ERROR = "[ERROR] 옳지 않은 범위의 숫자를 입력하셨습니다.";

    public static final String NUMBER_SIZE_ERROR = "[ERROR] 당첨 번호는 " + NUM_OF_LOTTO + "개 입력 가능합니다.";
    public static final String OVERLAP_NUM_ERROR = "[ERROR] 중복된 숫자가 존재합니다.";

    public static final String NOT_NUMBER_ERROR = "[ERROR] 숫자가 아닌 값을 입력하셨습니다.";
    public static final String INPUT_FORMAT_ERROR = "[ERROR] 입력값이" + LOTTO_PRICE + "로 나누어 떨어지지 않습니다.";

    public static void rangeException() {
        System.out.println(RANGE_ERROR);
    }

    public static void cntException() {
        System.out.println(NUMBER_SIZE_ERROR);
    }

    public static void overlapException() {
        System.out.println(OVERLAP_NUM_ERROR);
    }

    public static void typeException() {
        System.out.println(NOT_NUMBER_ERROR);
    }

    public static void numberFormatException() {
        System.out.println(INPUT_FORMAT_ERROR);
    }

}
