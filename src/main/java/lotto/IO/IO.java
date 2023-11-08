package lotto.IO;

import camp.nextstep.edu.missionutils.Console;

public class IO { //여긴 무조건 정적호출로 해보자

    public static String InputCash(){
        System.out.println("구입금액을 입력해주세요");
        return Console.readLine();
    }

    public static void PrintCount(int count){
        System.out.println(count+"개를 구매했습니다.");
    }

    public static String InputWinningLotto(){
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static String InputBonus(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonus = Console.readLine();
        return bonus;
    }

}

