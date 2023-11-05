package lotto.utils;

public enum Templates {
    BUY_MESSAGE("구입금액을 입력해 주세요."),
    GET_PRIZING_NUMBERS_MESSAGE("\n당첨 번호를 입력해 주세요."),
    GET_BONUS_NUMBER_MESSAGE("\n보너스 번호를 입력해 주세요."),
    BOUGHT_MESSAGE("\n%d개를 구매했습니다.\n"),
    RESULT_MESSAGE("\n당첨 통계\n---\n"),
    PRIZING_MESSAGE("%s (%s원) - %d개\n"),
    PROFIT_RATIO_MESSAGE("총 수익률은 %.1f%%입니다."),
    BUY_ERROR_MESSAGE("[ERROR] 금액은 1000원 단위이며, 1장부터 구매할 수 있습니다.\n"),
    PRIZING_ERROR_MESSAGE("[ERROR] 1~45까지의 중복되지 않는 수 6개를 입력해 주세요.\n[ERROR] 각 숫자는 콤마(,)로 구분해 주세요. 공백은 허용하지 않습니다."),
    BONUS_ERROR_MESSAGE("[ERROR] 당첨 번호와 중복되지 않는 1~45까지의 숫자를 입력해 주세요.");

    private String message;

    Templates(String message) {
        this.message = message;
    }


    public String format(Object... args) {
        return String.format(this.message, args);
    }
}
