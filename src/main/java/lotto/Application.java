package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        int numberOfLotto = 0;
        int money = 0;

        System.out.println("구입 금액을 입력해 주세요.");
        money = moneyInput(money);
        System.out.println();
        System.out.println("");
    }

    public static int moneyInput(int money){
        try {
            money = Integer.parseInt(Console.readLine());
        }catch(IllegalArgumentException e){
            System.out.println("[ERROR] 1000원 단위로 입력하여야 합니다.");
        }
        if((money%1000)!=0) throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력하여야 합니다. ");
        return money;
    }

}
