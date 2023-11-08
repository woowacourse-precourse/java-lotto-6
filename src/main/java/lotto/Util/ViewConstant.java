package lotto.Util;

public class ViewConstant {

    // 입력뷰 출력
    public static final String COST = "구입 금액을 입력해 주세요\n";
    public static final String AMOUNT = "\n%d개를 구매했습니다.\n";
    public static final String WINNING_NUMBER = "\n당첨 번호를 입력해 주세요.\n";
    public static final String BONUS_NUMBER = "\n보너스 번호를 입력해 주세요\n";
    public static final String BLACK = " ";
    public static final String BLACKNESS = "";
    public static final String COMMA = ",";

    // 결과 출력 용
    public static final String RESULT_FORMAT =
                        """
                        \n당첨 통계
                        ---
                        3개 일치 (5,000원) - %d개
                        4개 일치 (50,000원) - %d개
                        5개 일치 (1,500,000원) - %d개
                        5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
                        6개 일치 (2,000,000,000원) - %d개
                        총 수익률은 %.1f%%입니다.""";
    // 검증
    public static final String NUMBER_PATTERN = "^[0-9,\\s]+$";
    // 에러 메시지
    public static final String EMPTY_INPUT = "[ERROR] 빈 입력입니다.";
    public static final String ONLY_NUMBER = "[ERROR] 오직 숫자와 컴마(,)만 입력이 가능합니다.";
    public static final String LACK_INPUT = "[ERROR] 6자리만 입력해 주세요.";
    public static final String RANGE_ERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String DUPLICATION = "[ERROR] 중복된 입력입니다.";
    public static final String BANKNOTE = "[ERROR] 천원 단위만 입력 가능합니다.";
}
