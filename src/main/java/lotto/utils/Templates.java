package lotto.utils;

public enum Templates {
    // Values, Fields, Constructor
    BUY_MESSAGE("구입금액을 입력해 주세요.\n"),
    GET_PRIZING_NUMBERS_MESSAGE("\n당첨 번호를 입력해 주세요.\n"),
    GET_BONUS_NUMBER_MESSAGE("\n보너스 번호를 입력해 주세요.\n"),
    BOUGHT_MESSAGE("\n%d개를 구매했습니다.\n"),
    RESULT_MESSAGE("\n당첨 통계\n---\n"),
    PRIZING_MESSAGE("%s (%s원) - %s개\n"),
    PROFIT_RATIO_MESSAGE("총 수익률은 %.1f%%입니다.\n"),
    BUY_ERROR_MESSAGE("[ERROR] 금액은 1000원 단위이며, 1장부터 구매할 수 있습니다.\n"),
    PRIZING_ERROR_MESSAGE("[ERROR] 1~45까지의 중복되지 않는 수 6개를 입력해 주세요.\n[ERROR] 각 숫자는 콤마(,)로 구분해 주세요. 공백은 허용하지 않습니다.\n"),
    BONUS_ERROR_MESSAGE("[ERROR] 당첨 번호와 중복되지 않는 1~45까지의 숫자를 입력해 주세요.\n");

    private final String message;

    Templates(String message) {
        this.message = message;
    }


    // Features
    // Enum의 value를 호출하면 자동으로 toString 메소드를 실행하는데, 이 때 반환되는 것은 value의 이름이다. 이것을 message로 overriding
    @Override
    public String toString() {
        return message;
    }

    public String format(Object... args) {
        return String.format(this.message, args);
    }

}
