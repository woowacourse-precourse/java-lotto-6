package lotto.domain.constant;

import static lotto.domain.constant.NumberConstant.*;

public class StringConstant {
    // INPUT
    public static final String SPLIT_DELIMITER = ",";


    // TEST CASE
    public static final String TEST_EXPENSE_TYPE = "가나다라";
    public static final String TEST_EXPENSE_DIVIDE = "12345";
    public static final String TEST_WINNUMBERS_TYPE = "3,5,다,1,";
    public static final String TEST_WINNUMBERS_SORT = "6,5,4,3,2,1";
    public static final String TEST_BONUSNUMBER_TYPE = "가나다라";
    public static final String TEST_BONUSNUMBER_RANGE = "46";
    public static final String TEST_COMPUTE_EXPENSE = "1000";


    // OUTPUT SERVICE
    public static final String EXPENSE_INPUT_FORM_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String TICEKTNUM_PRINT_MESSAGE = "개를 구매했습니다.";
    public static final String WINNING_NUM_INPUT_FORM_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUM_INPUT_FORM_MESSAGE = "보너스 번호를 입력해 주세요.";
    public static final String RESULT_PRINT_MESSAGE = "당첨 통계\n---";
    public static final String MATCH_RESULT_UNIT_STRING = "개";
    public static final String MARGIN_MESSAGE_FRONT = "총 수익률은 ";
    public static final String MARGIN_MESSAGE_REAR = "%입니다.";


    // MATCH RESULT
    public static final String NONE_MATCH_RESULT_MESSAGE = "";
    public static final String THREE_MATCH_RESULT_MESSAGE = "3개 일치 (5,000원) - ";
    public static final String FOUR_MATCH_RESULT_MESSAGE = "4개 일치 (50,000원) - ";
    public static final String FIVE_MATCH_RESULT_MESSAGE = "5개 일치 (1,500,000원) - ";
    public static final String BONUS_MATCH_RESULT_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    public static final String SIX__MATCH_RESULT_MESSAGE = "6개 일치 (2,000,000,000원) - ";


    // ERROR
    public static final String ERROR_PREFIX = "[ERROR] ";
        // DYNAMIC
    public static final String LOTTO_SIZE_ERROR = LOTTO_SIZE + " 개의 로또 숫자를 입력해주세요.";
    public static final String LOTTO_IN_RANGE_ERROR = LOTTO_NUMBER_START + "과" + LOTTO_NUMBER_END + " 사이의 숫자를 입력해주세요.";
    public static final String LOTTO_EXPENSE_VALUER_ERROR = LOTTO_PRICE + "으로 나뉘는 구매 금액을 입력해주세요.";
        // STATIC
    public static final String LOTTO_DUPLICATE_ERROR = "서로 중복되지 않는 로또 숫자를 입력해주세요";
    public static final String LOTTO_NUM_TYPE_ERROR = "알맞은 숫자 타입을 입력해주세요.";
    public static final String LOTTO_BONUSNUM_DUPLICATE_ERROR = "당첨 로또와 중복되지 않는 보너스 숫자를 입력해주세요";
}
