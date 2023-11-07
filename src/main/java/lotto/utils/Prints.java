package lotto.utils;

public class Prints {
    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해주세요.";
    private static final String INPUT_WINLOTTO = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUSNUMBER = "보너스 번호를 입력해 주세요.";

    public static void print_input_amount_message() {
        System.out.println(INPUT_AMOUNT_MESSAGE);
    }

    public static void print_input_winLotto() {
        print_gap_line();
        System.out.println(INPUT_WINLOTTO);
    }

    public static void print_input_bonusnumber() {
        print_gap_line();
        System.out.println(INPUT_BONUSNUMBER);
    }

    private static void print_gap_line() {
        System.out.println();
    }

    public static void print_lottoCount(int lottoCount) {
        print_gap_line();
        System.out.println(String.format("%d개 를 구매하였습니다.", lottoCount));
    }
}
