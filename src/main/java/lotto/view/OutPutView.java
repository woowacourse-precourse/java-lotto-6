package lotto.view;

import static lotto.configuration.OutputConfiguration.INSERT_BONUS_NUMBER;
import static lotto.configuration.OutputConfiguration.INSERT_MONEY;
import static lotto.configuration.OutputConfiguration.INSERT_WIN_NUMBER;
import static lotto.configuration.OutputConfiguration.PURCHASED_LOTTO;
import static lotto.configuration.OutputConfiguration.WIN_STATISTICS;

public class OutPutView {

    public static void println(String out) {
        System.out.println(out);
    }
    public static void print(String out){
        System.out.print(out);
    }

    public static void printBuyTicket() {
        println(INSERT_MONEY.getMessage());
    }

    public static void printLottoCount(int lottoCount) {
        println("\n" + lottoCount + PURCHASED_LOTTO.getMessage());
    }

    public static void printLottos(String lottos) {
        println(lottos);
    }

    public static void printEnterWinNumber() {
        println("\n" + INSERT_WIN_NUMBER.getMessage());
    }

    public static void printBonusNumber() {
        println("\n" + INSERT_BONUS_NUMBER.getMessage());
    }

    public static void printMatchResult(String matchResult) {
        print(WIN_STATISTICS + matchResult);
    }
    public static void printReturnRate(double returnRate){
        System.out.printf("총 수익률은 %.1f%%입니다.",returnRate);
    }

}
