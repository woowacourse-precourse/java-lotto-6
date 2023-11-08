package lotto.message;

public enum LottoMessage implements Message {

    LOTTO_COUNT("%d개를 구매했습니다.\n"),
    DISPLAY_LOTTO_NUMBER_FORMAT("[%s]"),
    NOT_EXIST_BONUS_MESSEAGE("%d개 일치 (%s원) - %d개"),
    EXIST_BONUS_MESSAGE("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
    EARNING_RESULT_FORMAT("총 수익률은 %.1f%%입니다.");

    private final String message;

    LottoMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}
