package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.services.Amount;
import lotto.services.Bonus;
import lotto.services.Prize;

public class InputView {

    public int inputForAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String amount = Console.readLine();

        return new Amount().createAmount(amount);
    }

    public List<Integer> inputForPrizeNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String prize = Console.readLine();

        return new Prize().createPrizeNumber(prize);
    }

    public int inputForBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonus = Console.readLine();

        return new Bonus().createBonusNumber(bonus);
    }

    public void closeToConsole() {
        Console.close();
    }
}
