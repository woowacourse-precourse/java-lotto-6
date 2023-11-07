package lotto.utils;

public enum Prints {
    INPUT_AMOUNT_MESSAGE("구입금액을 입력해주세요."),
    INPUT_WINLOTTO("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUSNUMBER("\n보너스 번호를 입력해 주세요."),
    SHOW_GAME_RESULT("\n당첨 통계\n---"),
    SHOW_LOTTOCOUNT("\n%d개를 구매했습니다."),
    SHOW_ERROR_MSG("[ERROR] %s"),
    SHOW_RATE_OF_RETURN("총 수익률은 %.1f%%입니다.");
    private final String msg;

    Prints(String msg) {
        this.msg = msg;
    }

    public void show() {
        System.out.println(this.msg);
    }

    public void showFormat(int arg) {
        System.out.println(String.format(this.msg, arg));
    }

    public void showFormat(String arg) {
        System.out.println(String.format(this.msg, arg));
    }

    public void showFormat(double arg) {
        System.out.println(String.format(this.msg, arg));
    }

}
