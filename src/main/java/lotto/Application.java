package lotto;


import camp.nextstep.edu.missionutils.Console;

class MoneyInput{

    static int money;


    static void inputMoney(){

        System.out.println("구입 금액을 입력해 주세요.");
        String input = Console.readLine();
        Console.close();
        money = Integer.parseInt(input);

    }

    static void countLottoPapers(){
        money/=1000;
    }

}


public class Application {
    public static void main(String[] args) {

        MoneyInput.inputMoney();
        MoneyInput.countLottoPapers();
        System.out.println(MoneyInput.money);
    }
}
