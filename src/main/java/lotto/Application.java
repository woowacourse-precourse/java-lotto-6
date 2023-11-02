package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        User.InputMoney();
    }
}

class User {
    public static void InputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String m = Console.readLine();
        int money = Integer.parseInt(m);
    }
}