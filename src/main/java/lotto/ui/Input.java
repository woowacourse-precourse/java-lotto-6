package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Input {
    InputConverter converter = new InputConverter();

    public long askToPay() {
        System.out.println("구입 금액을 입력해주세요.");
        return converter.convertToMoney(Console.readLine());
    }

    public List<Integer> askWinningNumber() {
        System.out.println();
        System.out.println("당첨 번호를 입력해주세요. (숫자 6개 입력)");
        return converter.convertToWinningNumbers(Console.readLine());
    }

    public int askBonus() {
        System.out.println();
        System.out.println("보너스 번호를 입력해주세요.");
        return converter.convertToBonusNumber(Console.readLine());
    }
}
