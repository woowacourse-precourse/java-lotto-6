package lotto.util;

import java.util.regex.Pattern;

public class Constants {
    //정규 표현식 이용
    public static final Pattern numsStringPattern = Pattern.compile("\\d+(,\\d+)*");
    public static final Pattern nonDigitPattern = Pattern.compile("\\D");

    public static final String ERROR = "[ERROR] ";
    public static final String NUM_WRONG_ERROR = ERROR +"로또 번호 입력은 쉼표로 구분되어 있어야 하며, 공백을 포함하지 않아야 하며, 숫자를 입력해야 한다";
    public static final String NUM_SIZE_ERROR= ERROR+"로또 번호의 숫자 범위는 1~45까지이다.";
    public static final String NUM_DUPLICATE_EORROR = ERROR+"중복된 로또 번호는 허용하지 않습니다.";
    public static final String NUM_COUNT_ERROR = ERROR+"로또 당첨 번호는 6개를 입력해야 합니다.";
    public static final String NUM_IS_INT = ERROR+"숫자를 입력하세요.";
    public static final String COST_ERROR = ERROR +"1000원 단위의 입력만 가능합니다.";
    public static final String COST_WRONG_ERROR= ERROR + "음수가 아닌 양수를 입력해 주십시오";

    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 45;
    public static final int PICK_NUM = 6;






    public static final String START_COST_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String START_NUM_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String START_BONUS_MESSAGE = "보너스 번호를 입력해 주세요.";
    public static final String LOTTO_MESSAGE = "개를 구매했습니다.";
    public static final String END_RESULT_MESSAGE = "당첨 통계\n---";
    public static final String END_RESULT_MESSAGE_3 = "3개 일치 (5,000원) - ";
    public static final String END_RESULT_MESSAGE_4 = "4개 일치 (50,000원) - ";
    public static final String END_RESULT_MESSAGE_5 = "5개 일치 (1,500,000원) - ";
    public static final String END_RESULT_MESSAGE_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    public static final String END_RESULT_MESSAGE_6 = "6개 일치 (2,000,000,000원) - ";
    public static final String END_RESULT = "총 수익률은 ";

}
