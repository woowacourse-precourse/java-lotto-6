package lotto.utils;

public class Prints {
    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해주세요.";

    public static void print_input_amount_message() {
        System.out.println(INPUT_AMOUNT_MESSAGE);
    }

    private static void print_gap_line() {
        System.out.println();
    }

    public static void print_lottoCount(int lottoCount) {
        print_gap_line();
        System.out.println(String.format("%d개 를 구매하였습니다.", lottoCount));
    }
}
