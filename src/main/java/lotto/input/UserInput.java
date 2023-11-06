package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BonusNumber;
import lotto.domain.Money;
import lotto.domain.WinningNumber;

public class UserInput {
    public final String INPUT_PURCHASE_MONEY = "구입금액을 입력해주세요";
    public final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    public final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public Money askMoney() {
        System.out.println(INPUT_PURCHASE_MONEY);
        String inputMoney = Console.readLine();
        return new Money(inputMoney);
    }

    public WinningNumber askWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBERS);
        String inputWinning = Console.readLine();
        return new WinningNumber(inputWinning);
    }

    public BonusNumber askBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        String inputBonus = Console.readLine();
        return new BonusNumber(inputBonus);
    }
}