package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        MyLotto.LottoPaper(Money.InputMoney());
    }
}

class Money {
    public static int InputMoney() {
        while (true) {
            try{
                System.out.println("구입금액을 입력해 주세요.");
                String m = Console.readLine();
                return ExceptMoney(m);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int ExceptMoney(String money){
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }

    public static int CorrectMoney(int money) {
        if (money % 1000 == 0) {
            return money / 1000;
        }
        throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요.");
    }
}

class MyLotto{
    public static void LottoPaper(int cnt) {
        ArrayList<List<Integer>> mylotto = new ArrayList<>();

        for (int i = 0; i < cnt; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            mylotto.add(numbers);
        }
        PrintLottoPaper(cnt, mylotto);
    }
    public static void PrintLottoPaper(int cnt, ArrayList<List<Integer>> mylotto){
        System.out.println();
        System.out.println(cnt+"개를 구매했습니다.");
        for (List<Integer> row : mylotto) {
            System.out.println(row);
        }
    }
}

class WinnigNum {
    public static String InputLottoNum(){
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningnum = Console.readLine();
        return winningnum;
    }
    public static List<Integer> LottoNum(String winningnum){
        String[] num = winningnum.split(",");
        List<Integer> num_lst = new ArrayList<>();
        for (String str : num) {
            num_lst.add(Integer.parseInt(str.trim()));
        }
        return num_lst;
    }
    public static String InputBonus(){
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusnum = Console.readLine();
        return bonusnum;
    }
    public static int BonusNum(String bonusnum){
        return Integer.parseInt(bonusnum);
    }
}