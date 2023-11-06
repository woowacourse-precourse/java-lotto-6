package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

class money_for_lotto{
    public static int realNumber;

    public static int realMoney(String inputNumber){
        moneyIsNumber(inputNumber);
        realNumber = Integer.parseInt(inputNumber);
        moneyIsOver0(realNumber);
        multipleOfThousand(realNumber);
        return Integer.parseInt(inputNumber);
    }

    public static void moneyIsNumber(String inputNumber){
        try{
            Integer.parseInt(inputNumber);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요");
        }
    }

    public static void moneyIsOver0(int realNumber){
        if(realNumber<1){
            throw new IllegalArgumentException("[ERROR] 0보다 큰 수를 입력하세요");
        }
    }
    public static void multipleOfThousand(int realNumber){
        if(realNumber%1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1000의 배수를 입력하세요");
        }
    }

    public static int repeatTime(int realNumber){
        return realNumber/1000;
    }

}

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String inputMoney = Console.readLine();
        int realMoney = money_for_lotto.realMoney(inputMoney);
        int repeatTime = money_for_lotto.repeatTime(realMoney);


    }
}
