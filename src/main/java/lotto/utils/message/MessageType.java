package lotto.utils.message;

public enum MessageType {
    INPUT_LOTTO_PRICE("구입금액을 입력해 주세요."),
    OUTPUT_LOTTO_CNT("%d개를 구매했습니다."),
    INPUT_LOTTO_NUMBER("당첨 번호를 입력해주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    OUTPUT_RESULT_TITLE("당첨 통계\n---"),
    OUTPUT_RESULT("%s - %d개"),
    OUT_PERCENTAGE("총 수익률은 %.1f%%입니다.");

    private final String message;


    MessageType(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
