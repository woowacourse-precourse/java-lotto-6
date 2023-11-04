package lotto.view;

public enum OutputView {

    INPUT_PURCHASE_PRICE("구입금액을 입력해 주세요.") ,
    PURCHASE_AMOUNT("%d개를 구매했습니다.\n"),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PRINT_1ST("6개 일치 (2,000,000,000원) - %d개"),
    PRINT_2ST("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    PRINT_3ST("5개 일치 (1,500,000원) - %d개"),
    PRINT_4ST("4개 일치 (50,000원) - %d개"),
    PRINT_5ST("3개 일치 (5,000원) - %d개"),
    PRINT_RATE_OR_RETURN("총 수익률은 %.2f%%입니다."),
    WINNING_STATISTICS("당첨 통계");

    private String message;

    public String getMessage() {
        return message;
    }

    OutputView(String message) {
        this.message = message;
    }

}
