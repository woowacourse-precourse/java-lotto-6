package lotto.constant;

public enum Message {
    INPUT_MONEY(MessageType.INPUT, "구입금액을 입력해 주세요."),
    INPUT_ANSWER(MessageType.INPUT, "\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS(MessageType.INPUT, "\n보너스 번호를 입력해 주세요."),

    OUTPUT_MY_LOTTOS(MessageType.OUTPUT, "\n%d개를 구매했습니다.\n"),
    OUTPUT_PREPARE_RESULT(MessageType.OUTPUT, "\n당첨 통계\n---"),
    OUTPUT_RESULT_FORMAT(MessageType.OUTPUT, "%d개 일치 (%,d원) - %d개\n"),
    OUTPUT_RESULT_FORMAT_BONUS(MessageType.OUTPUT, "5개 일치, 보너스 볼 일치 (%,d원) - %d개\n"),
    OUPTUT_OVERALL_ROI(MessageType.OUTPUT, "총 수익률은 %s%%입니다."),

    ERROR_INPUT_NOT_NUMBER(MessageType.ERROR, "입력값이 숫자여야 합니다."),
    ERROR_MONEY_REMAINDER(MessageType.ERROR, "구입 금액은 1,000원 단위로 입력되어야 합니다."),
    ERROR_NUMBER_RANGE(MessageType.ERROR, "로또 번호는 1부터 45 사이의 숫자여야 합니다."),

    ERROR_BONUS_DUPLICATE(MessageType.ERROR, "입력한 보너스 번호가 당첨 번호 중에 이미 존재합니다."),
    ERROR_LOTTO_SIZE(MessageType.ERROR, "로또 번호의 갯수가 잘못되었습니다."),
    ERROR_LOTTO_DUPLICATE(MessageType.ERROR, "입력한 로또 번호 중 중복 번호가 존재합니다."),
    ;

    private final MessageType type;
    private final String msg;

    Message(MessageType type, String msg){
        this.type = type;
        if (type == MessageType.ERROR){
            msg = "[ERROR]" + msg;
        }
        this.msg = msg;
    }
    public String getMsg(){
        return msg;
    }
}
