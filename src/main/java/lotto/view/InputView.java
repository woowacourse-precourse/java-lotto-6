package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int inputLottoPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        return money;
    }

    public int inputWinningNumber(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
        int winningNumber = Integer.parseInt(Console.readLine());
        return winningNumber;
    }

    public int inputBonusNumber(){
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        return bonusNumber;
    }
}
