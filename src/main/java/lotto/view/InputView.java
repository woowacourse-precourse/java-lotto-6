package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String readPrice(){
        System.out.println("구매금액을 입력해주세요.");
        return Console.readLine();
    }

    public String readLotto(){
        System.out.println("당첨번호를 입력해주세요.");
        return Console.readLine();
    }

    public String readBonusNumber(){
        System.out.println("보너스 번호를 입력해주세요.");
        return Console.readLine();
    }
}
