package lotto.view;

public class OutputView {

    public static void print(String name) {
        System.out.println(OutputMode.valueOfLabel(name));
    }

    public static void print_value_front(String name, String value) {
        System.out.println(value + OutputMode.valueOfLabel(name));
    }
}

enum OutputMode {
    BUY_CASH("구입금액을 입력해 주세요."),
    GET_LOTTO("개를 구매했습니다."),
    LOTTO_WINN("당첨 번호를 입력해 주세요."),
    LOTTO_BOUNS("보너스 번호를 입력해 주세요."),
    LOTTO_1("6개 일치 (2,000,000,000원) - "),
    LOTTO_2("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    LOTTO_3("5개 일치 (1,500,000원) - "),
    LOTTO_4("4개 일치 (50,000원) - "),
    LOTTO_5("3개 일치 (5,000원) - "),
    LOTTO_RETURN("당첨 통계\n---"),
    LOTTO_PROFIT("총 수익률은 ");
    private final String label;

    OutputMode(String s) {
        this.label = s;
    }

    public String label() {
        return label;
    }

    public static String valueOfLabel(String label) {
        return valueOf(label).label();
    }

}