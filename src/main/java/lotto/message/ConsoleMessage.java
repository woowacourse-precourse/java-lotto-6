package lotto.message;

public enum ConsoleMessage {


    //Input Message
    GET_PURCHASE_MONEY("구입금액을 입력해 주세요."),
    GET_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    GET_BONUS_NUMBER("보너스 번호를 입력해 주세요."),

    //Output Message
    CREATE_LOTTOS_COUNT("개를 구매했습니다."),
    PRINT_LOTTO_RESULT("당첨 통계"),
    PRINT_SEPERATE_STRING("---"),
    PRINT_5_RANK_RESULT("3개 일치 (5,000원) - "),
    PRINT_4_RANK_RESULT("4개 일치 (50,000원) - "),
    PRINT_3_RANK_RESULT("5개 일치 (1,500,000원) - "),
    PRINT_2_RANK_RESULT("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    PRINT_1_RANK_RESULT("6개 일치 (2,000,000,000원) - "),
    PRINT_TOTAL_RESULT("총 수익률은 "),
    PRINT_TOTAL_RESULT_END_WORD("%입니다."),

    //Error Message
    ERROR_STRING("[ERROR] "),
    LOTTO_NUMBER_RANGE_ERROR("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_NUMBER_DUPLICATE_ERROR("로또 넘버는 중복이 될 수 없습니다."),
    LOTTO_NUMBER_SIZE_ERROR("당첨 번호는 6자리 수 여야 합니다."),
    PURCHASE_MONEY_ERROR("로또 구입 금액은 1,000원 단위로 나누어 떨어져야 합니다.");
    private ConsoleMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    private String message;
}
