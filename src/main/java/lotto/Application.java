package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

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
        LottoPaper(CorrectMoney(money));
    }
    public static int CorrectMoney(int money){
        if (money % 1000 == 0){
            return money / 1000;
        }
        throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
    }
    public static void LottoPaper(int cnt){
        ArrayList<List<Integer>> mylotto = new ArrayList<>();

        for (int i = 0; i < cnt; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            mylotto.add(numbers);
        }
        PrintLottoPaper(cnt, mylotto);
    }
}