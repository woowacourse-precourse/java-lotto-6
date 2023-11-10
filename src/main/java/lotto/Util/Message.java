package lotto.Util;

public enum Message {
    REQUEST_PAYMENT("구입금액을 입력해 주세요."),
    NUMBER_OF_PURCHASE("개를 구매했습니다."),
    REQUEST_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    CHECK_WINNING_MESSAGE("당첨 통계\n---"),
    FIRST_PLACE_MESSAGE("6개 일치 (2,000,000,000원) - %d개\n"),
    SECOND_PLACE_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    THIRD_PLACE_MESSAGE("5개 일치 (1,500,000원) - %d개\n"),
    FOURTH_PLACE_MESSAGE("4개 일치 (50,000원) - %d개\n"),
    FIFTH_PLACE_MESSAGE("3개 일치 (5,000원) - %d개\n"),
    TOTAL_YIELD_MESSAGE("총 수익률은 %.1f%%입니다.\n"),
    PAYMENT_ERROR_MESSAGE("[ERROR]1000원 단위로만 입력 가능합니다."),
    LOTTO_ERROR_MESSAGE("[ERROR]1~45 사이의 6개의 숫자만 입력 가능하며, 중복은 허용되지 않습니다."),
    BONUS_NUMBER_ERROR_MESSAGE("[ERROR]1~45 사이의 로또 번호와 중복되지 않는 숫자만 입력 가능합니다.");
    private final String message;

    Message(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
