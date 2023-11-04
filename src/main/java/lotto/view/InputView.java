package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String buyMessage = "구입금액을 입력해 주세요.";
    private final String getPrizingNumbersMessage = "\n당첨 번호를 입력해 주세요.";
    private final String getBonusNumberMessage = "\n보너스 번호를 입력해 주세요.";

    public String getUserBuyAmount() {
        System.out.println(buyMessage);
        String amount = Console.readLine();

        return amount;
    }

    public String getPrizingNumbers() {
        System.out.println(getPrizingNumbersMessage);
        String numbers = Console.readLine();

        return numbers;
    }

    public String getBonusNumbers() {
        System.out.println(getBonusNumberMessage);
        String bonus = Console.readLine();

        return bonus;
    }

}
