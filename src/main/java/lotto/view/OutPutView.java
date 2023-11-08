package lotto.view;

public class OutPutView {
    final static String INSERT_MONEY = "구입금액을 입력해 주세요.";
    final static String INSERT_WIN_NUMBER = "당첨 번호를 입력해 주세요.";
    final static String INSERT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    final static String PURCHASED_LOTTO = "개를 구매했습니다.";
    final static String WIN_STATISTICS = "\n당첨 통계\n---\n";
    final static String RETURN_RATE_OPENING = "총 수익률은 ";
    final static String RETURN_RATE_CLOSING = "%%입니다.";

    public static void println(String out) {
        System.out.println(out);
    }
    public static void print(String out){
        System.out.print(out);
    }

    public static void printBuyTicket() {
        println(INSERT_MONEY);
    }

    public static void printLottoCount(int lottoCount) {
        println("\n" + lottoCount + PURCHASED_LOTTO);
    }

    public static void printLottos(String lottos) {
        println(lottos);
    }

    public static void printEnterWinNumber() {
        println("\n" + INSERT_WIN_NUMBER);
    }

    public static void printBonusNumber() {
        println("\n" + INSERT_BONUS_NUMBER);
    }

    public static void printMatchResult(String matchResult) {
        print(WIN_STATISTICS + matchResult);
    }
    public static void printReturnRate(double returnRate){
        System.out.printf(RETURN_RATE_OPENING+"%.1f"+RETURN_RATE_CLOSING,returnRate);
    }

}
