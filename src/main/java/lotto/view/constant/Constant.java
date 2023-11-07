package lotto.view.constant;

public enum Constant {

    // TODO 게터이외에 메시지를 이용하는 메서드 구현이 필요함

    //입력 메시지
    INPUT_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    INPUT_LOTTO_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),

    //출력 메시지
    FRONT_BRACKETS("["),
    REAR_BRACKETS("]"),
    COMMAS(","),
    STATISTICS_HEADER(System.lineSeparator() + "당첨 통계" + "---------"),
    BUYING_COUNT("%d개를 구매했습니다."),
    STATISTICS("%d개 일치%s(%d원)- %d개" + System.lineSeparator()),
    TAKE_BONUS(", 보너스 볼 일치"),
    PROFIT("총 수익률은 %.2f입니다.");

    private final String message;

    Constant(String message) {
        this.message = message;
    }

    String message() {
        return message;
    }
}
