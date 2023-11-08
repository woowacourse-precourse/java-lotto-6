package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String buyAmountInput = "구매 금액을 입력해주세요";
    private final String winningNumbersInput = "당첨 번호를 입력해주세요";

    private final String bonusNumber = "보너스 번호를 입력해 주세요.";

    public int readBuyAmount(){
        System.out.println(buyAmountInput);

        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자를 입력하세요.");
        }
    }

    public String readWinningNumbers(){
        System.out.println(winningNumbersInput);
        return Console.readLine();
    }

    public int readBonusNumber(){
        System.out.println(bonusNumber);

        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자를 입력하세요.(숫자는 하나만 입력할 수 있습니다.)");
        }
    }
}
