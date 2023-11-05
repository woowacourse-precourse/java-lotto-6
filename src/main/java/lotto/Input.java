package lotto;
import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static int money(){
        int money = Integer.parseInt(Console.readLine());
        //TODO: exception 추가 - money가 1000으로 나누어 떨어지지 않을때
        return money;
    }

    public static void winningNumbers(){

    }

    public static void bonusNumber(){

    }
}
