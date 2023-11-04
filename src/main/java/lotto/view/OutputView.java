package lotto.view;

public enum OutputView {

    INPUT_PURCHASE_PRICE("구입금액을 입력해 주세요.") ,
    PURCHASE_AMOUNT("%d개를 구매했습니다.\n"),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계");

    private String message;

    public String getMessage() {
        return message;
    }

    OutputView(String message) {
        this.message = message;
    }

}
