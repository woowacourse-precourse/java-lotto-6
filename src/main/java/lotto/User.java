package lotto;

import camp.nextstep.edu.missionutils.Console;

public class User {

    // TODO: 1000원 단위인지 validate
    public int inputAmountOfMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String amountOfMoney = Console.readLine();
        return Integer.parseInt(amountOfMoney);
    }

    public String inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String inputBonusNumbers() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
