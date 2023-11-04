package lotto;

import static lotto.message.LottoGameAnnouncement.ASK_PURCHASE_MONEY;

import camp.nextstep.edu.missionutils.Console;

public class LottoGameReader {
    public static LottoMoney getMoneyFromConsole() {
        while (true) {
            try {
                System.out.println();
                System.out.println(ASK_PURCHASE_MONEY.getMessage());
                String input = Console.readLine();
                return new LottoMoney(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
