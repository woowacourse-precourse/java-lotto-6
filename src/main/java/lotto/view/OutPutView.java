package lotto.view;

import static lotto.configuration.OutputConfiguration.INSERT_BONUS_NUMBER;
import static lotto.configuration.OutputConfiguration.INSERT_MONEY;
import static lotto.configuration.OutputConfiguration.INSERT_WIN_NUMBER;
import static lotto.configuration.OutputConfiguration.PURCHASED_LOTTO;

public class OutPutView {

    public static void println(String out) {
        System.out.println(out);
    }

    public static void printBuyTicket() {
        println(INSERT_MONEY.getMessage());
    }

    public static void printLottoCount(int lottoCount) {
        println("\n"+lottoCount+PURCHASED_LOTTO.getMessage());
    }

    public static void printLottos(String lottos) {
        println(lottos);
    }

    public static void printEnterWinNumber() {
        println("\n"+INSERT_WIN_NUMBER.getMessage());
    }


    public static void printBonusNumber() {
        println("\n"+INSERT_BONUS_NUMBER.getMessage());
    }
}
