package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.utils.Constants.BUY_LOTTERY_INPUT;
import static lotto.utils.Constants.TICKETS_COUNT_OUTPUT;

public class InputView {

    public static void payForLottery() {
        System.out.println(BUY_LOTTERY_INPUT);
        String string = Console.readLine();
        getTickets(string);
    }

    public static void getTickets(String string) {
        System.out.println();
        int payment = Integer.parseInt(string);
        System.out.printf(TICKETS_COUNT_OUTPUT, payment / 1000);
    }
}
