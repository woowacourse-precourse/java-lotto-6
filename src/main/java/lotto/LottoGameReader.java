package lotto;

import static lotto.message.LottoGameAnnouncement.ASK_BONUS_NUMBER;
import static lotto.message.LottoGameAnnouncement.ASK_PURCHASE_MONEY;
import static lotto.message.LottoGameAnnouncement.ASK_WIN_NUMBERS;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.BonusNumber;
import lotto.message.LottoGameAnnouncement;

public class LottoGameReader {
    public static LottoMoney getMoneyFromConsole() {
        while (true) {
            try {
                String input = readFromConsole(ASK_PURCHASE_MONEY);
                return new LottoMoney(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Lotto getWinNumberFromConsole() {
        while (true) {
            try {
                String input = readFromConsole(ASK_WIN_NUMBERS);
                return new Lotto(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static BonusNumber getBonusNumberFromConsole() {
        while (true) {
            try {
                String input = readFromConsole(ASK_BONUS_NUMBER);
                return new BonusNumber(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String readFromConsole(LottoGameAnnouncement announcement) {
        System.out.println();
        System.out.println(announcement.getMessage());
        return Console.readLine();
    }
}
