package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        User.InputMoney();
    }
}

class User{
    public static void InputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String m = Console.readLine();
        int money = Integer.parseInt(m);
        System.out.println(CorrectMoney(money));
    }
    public static int CorrectMoney(int money){
        if (money % 1000 == 0){
            return money / 1000;
        }
        throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
    }
}