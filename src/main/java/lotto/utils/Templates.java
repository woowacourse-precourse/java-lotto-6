package lotto.utils;

public enum Templates {
    BUY_MESSAGE("구입금액을 입력해 주세요."),
    GET_PRIZING_NUMBERS_MESSAGE("\n당첨 번호를 입력해 주세요."),
    GET_BONUS_NUMBER_MESSAGE("\n보너스 번호를 입력해 주세요.");

    private String message;

    Templates(String message) {
        this.message = message;
    }


    public String format(Object... args) {
        return String.format(this.message, args);
    }
}
