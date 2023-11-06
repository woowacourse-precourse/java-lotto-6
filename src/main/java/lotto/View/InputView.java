package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getLine(){
        return Console.readLine();
    }

    public void askPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void askWinningNums(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }
    public void askBonusNum(){
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }
}
