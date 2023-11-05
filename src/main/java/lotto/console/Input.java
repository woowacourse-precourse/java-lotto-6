package lotto.console;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Asset;

public class Input {
    public static Asset askMoney(){
        try{
            System.out.println("구입금액을 입력해 주세요.");
            Float money = Float.valueOf(Console.readLine());
            return new Asset(money);
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] :" + e.getMessage());
            return askMoney();
        }
    }

    public static String askWinningNum(){
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static String askBonusNum(){
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
