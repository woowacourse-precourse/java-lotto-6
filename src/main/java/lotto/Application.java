package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

enum PrizeRank {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000);

    private final int prizeAmount;

    PrizeRank(int prizeAmount){
        this.prizeAmount = prizeAmount;
    }
    public int getPrizeAmount(){ return prizeAmount; }
}

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

class WinningCaculate {
    public static List<Integer> Calculate(List<Integer> nums, List<Integer> num_lst, int bonus) {
        int mat_num = 0;
        List<Integer> mat_cnt = List.of(0, 0, 0, 0, 0, 0, 0, 0);
        List<Integer> match_cnt = MatchCount(nums, num_lst, mat_num, mat_cnt, bonus);
        return match_cnt;
    }
    public static List<Integer> MatchCount(List<Integer> nums, List<Integer> num_lst, int mat_num, List<Integer> match_cnt, int bonus){
        List<Integer> matchcnt = new ArrayList<>(match_cnt);
        for (int i = 0; i < nums.size(); i++) {
            if (i % 6 == 0 || i == nums.size()-1){
                int n = SpecialCount(mat_num, bonus, nums);
                matchcnt.set(n, matchcnt.get(n)+1);
                mat_num = 0;
            }
            if (num_lst.contains(nums.get(i))){
                mat_num += 1;
            }
        }
        return matchcnt;
    }
    public static int SpecialCount(int mat_num, int bonus, List<Integer> nums){
        if (mat_num == 5 && nums.contains(bonus)){
            return 6;
        }
        return mat_num;
    }
}