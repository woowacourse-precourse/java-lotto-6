package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String InputMoneyMessage = "구입금액을 입력해 주세요.";
    private static final String Input1stNumMessage = "당첨 번호를 입력해 주세요.";
    private static final String InputBonusNumMessage = "보너스 번호를 입력해 주세요.";


    public String inputMoney(boolean isRedo) {
        if (!isRedo) {
            System.out.println(InputMoneyMessage);
        }
        return userInput();
    }

    public String input1stNums(boolean isRedo) {
        if (!isRedo) {
            System.out.println();
            System.out.println(Input1stNumMessage);
        }
        return userInput();
    }

    public String inputBonusNum(boolean isRedo) {
        if (!isRedo) {
            System.out.println();
            System.out.println(InputBonusNumMessage);
        }
        return userInput();
    }

    private String userInput() {
        return Console.readLine();
    }
}
