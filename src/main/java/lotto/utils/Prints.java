package lotto.utils;

public class Prints {
    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해주세요.";
    private static final String INPUT_WINLOTTO = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUSNUMBER = "\n보너스 번호를 입력해 주세요.";
    private static final String SHOW_GAME_RESULT = "\n당첨 통계\n---";

    public static void print_input_amount_message() {
        System.out.println(INPUT_AMOUNT_MESSAGE);
    }

    public static void print_input_winLotto() {
        System.out.println(INPUT_WINLOTTO);
    }

    public static void print_input_bonusnumber() {
        System.out.println(INPUT_BONUSNUMBER);
    }

    public static void print_game_result() {
        System.out.println(SHOW_GAME_RESULT);
    }

    public static void print_lottoCount(int lottoCount) {
        System.out.println(String.format("\n%d개를 구매했습니다.", lottoCount));
    }
}
