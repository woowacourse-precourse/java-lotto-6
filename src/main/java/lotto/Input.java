package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public String pickSixNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }
    public String  pickBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
    public String buyAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }


}
