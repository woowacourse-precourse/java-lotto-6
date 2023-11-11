package lotto.view;

import static lotto.message.FlagInput.FLAG_AMOUNT_AFTER;
import static lotto.message.FlagInput.FLAG_AMOUNT_BEFORE;
import static lotto.message.FlagInput.FLAG_BONUS_AFTER;
import static lotto.message.FlagInput.FLAG_BONUS_BEFORE;
import static lotto.message.FlagInput.FLAG_PRIZE_AFTER;
import static lotto.message.FlagInput.FLAG_PRIZE_BEFORE;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.services.Amount;
import lotto.services.Bonus;
import lotto.services.Prize;

public class InputView {

    public int inputForAmount() {
        boolean flag = FLAG_AMOUNT_BEFORE.getMessage();
        int result = 0;

        while (flag != FLAG_AMOUNT_AFTER.getMessage()) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String amount = Console.readLine();

                result = new Amount().createAmount(amount);

                flag = FLAG_AMOUNT_AFTER.getMessage();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }

    public List<Integer> inputForPrizeNumber() {
        boolean flag = FLAG_PRIZE_BEFORE.getMessage();
        List<Integer> result = new ArrayList<>();
        while (flag != FLAG_PRIZE_AFTER.getMessage()) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String prize = Console.readLine();

                result = new Prize().createPrizeNumber(prize);

                flag = FLAG_PRIZE_AFTER.getMessage();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }

    public int inputForBonusNumber() {
        boolean flag = FLAG_BONUS_BEFORE.getMessage();
        int result = 0;
        while (flag != FLAG_BONUS_AFTER.getMessage()) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String bonus = Console.readLine();

                result = new Bonus().createBonusNumber(bonus);

                flag = FLAG_BONUS_AFTER.getMessage();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }

    public void closeToConsole() {
        Console.close();
    }
}
