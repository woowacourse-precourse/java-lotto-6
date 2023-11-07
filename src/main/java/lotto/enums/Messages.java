package lotto.enums;

public enum Messages {
    INPUT_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    INPUT_WINNUMER_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_BONUSNUMER_MESSAGE("보너스 번호를 입력해 주세요."),
    OUTPUT_BUY_MESSAGE("개를 구매했습니다."),
    LOTTERY_STATISTICS("당첨 통계"),
    WIN_FIRST_MESSAGE("6개 일치 (2,000,000,000원) - "),
    WIN_SECOND_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    WIN_THIRD_MESSAGE("5개 일치 (1,500,000원) - "),
    WIN_FOURTH_MESSAGE("4개 일치 (50,000원) - "),
    WIN_FIFTH_MESSAGE("3개 일치 (5,000원) - "),
    NUMBER_RANGE_ERROR_MESSAGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NUMBER_COUNT_ERROR_MESSAGE("[ERROR] 로또 번호는 6개여야 합니다."),
    NUMBER_DUPULICATE_MESSAGE("[ERROR] 로또 번호는 중복되지 않아야 합니다."),
    PRICE_DEVIDE_ERROR_MESSAGE("[ERROR] 1000원 단위로 입력해야 합니다."),
    PURE_INTEGER_ERROR_MESSAGE("[ERROR] 정수 입력이여야 합니다."),
    ;

    private String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
