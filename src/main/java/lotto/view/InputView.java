package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.StringUtil;

public class InputView {

    public int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String amount = Console.readLine();
        validateNullInput(amount);
        return StringUtil.parseInt(amount);
    }

    public List<Integer> inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumber = Console.readLine();
        validateNullInput(winningNumber);
        return StringUtil.parseComma(winningNumber);
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        validateNullInput(bonusNumber);
        return StringUtil.parseInt(bonusNumber);
    }

    private void validateNullInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

}
