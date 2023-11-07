package constants;

public enum LottoGameMessage {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASED_COUNT("%d개를 구매했습니다."),
    WINNING_NUMBER("\n당첨 번호를 입력 해 주세요."),
    BONUS_NUMBER("\n보너스 번호를 입력 해 주세요."),
    WINNING_STATISTICS("당첨 통계\n---");

    private String message;

    LottoGameMessage(String message){
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}