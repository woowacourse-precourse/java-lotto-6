package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Money {
    static int money;
    static int lottoNum;

    static void inputMoney(){

        System.out.println("구입 금액을 입력해 주세요.");
        String input = Console.readLine();
        Console.close();
        money = Integer.parseInt(input);

    }

    static void printLottoNum(){

        lottoNum = money/1000;
        System.out.println();
        System.out.println(lottoNum+"개를 구매했습니다.");

    }


}
