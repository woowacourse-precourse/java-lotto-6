package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Money {
    static int money;
    static int lottoNum;

    static void inputMoney(){

        System.out.println("구입 금액을 입력해 주세요.");
        while (true) {
            try {
                String input = Console.readLine();
                money = Integer.parseInt(input);
                checkMoney(money);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 유효한 정수를 입력하세요.");
            }
        }

    }

    static void checkMoney(int money){
        if(money%1000!=0){
            throw new IllegalArgumentException();
        }


    }
    static void printLottoNum(){

        lottoNum = money/1000;
        System.out.println();
        System.out.println(lottoNum+"개를 구매했습니다.");

    }




}
