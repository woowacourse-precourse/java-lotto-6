package lotto.util;

import java.util.regex.Pattern;

public class Constants {
    //정규 표현식 이용
    public static final Pattern numsStringPattern = Pattern.compile("\\d+(,\\d+)*");
    public static final Pattern nonDigitPattern = Pattern.compile("\\D");

    public static final String ERROR = "[ERROR] ";
    public static final int START_NUM = 1;
    public static final int END_NUM = 45;
    public static final int LOTTO_NUM = 6;






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
