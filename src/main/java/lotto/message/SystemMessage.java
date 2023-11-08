package lotto.message;

public enum SystemMessage implements MessageProvider{
    INPUT_PURCHASE_PRICE("구입금액을 입력해 주세요."),
    OUTPUT_PURCHASE_LOTTO_AMOUNT("%d개를 구매했습니다."),
    OUTPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    OUTPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    OUTPUT_WINNING_STATISTICS("당첨 통계\n" + "---"),
    OUTPUT_LOTTO_RESULT("%s (%,d원) - %d개"),
    OUTPUT_GAME_RETURN("총 수익률은 %.1f%%입니다.");

    private final String message;

    SystemMessage(String message) {
        this.message = message;}

    public String getMessage() {
        return message;
    }
}
