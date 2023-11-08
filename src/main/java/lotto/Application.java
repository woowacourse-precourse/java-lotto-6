package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
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
        int money = Money.InputMoney();
        List<Integer> numbers = MyLotto.LottoPaper(Money.CorrectMoney(money));
        List<Integer> num_lst = WinnigNum.LottoNum(WinnigNum.InputLottoNum());
        int bonus = WinnigNum.BonusNum(WinnigNum.InputBonus());
        Lotto lotto = new Lotto(num_lst);
        List<Integer> mat_num = WinningCaculate.Calculate(numbers, num_lst, bonus);
        WinningResult.EarningResult((WinningCaculate.EarningRate(WinningCaculate.Rank(mat_num), money)));
    }
}
class Money {
    public static int InputMoney() {
        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                String m = Console.readLine();
                return ExceptMoney(m);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int ExceptMoney(String money) {
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

class MyLotto {
    public static List<Integer> LottoPaper(int cnt) {
        ArrayList<List<Integer>> mylotto = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            mylotto.add(numbers);
        }
        ResultLottoPaper(cnt, mylotto);
        List<Integer> numbers = MakeFlattend(mylotto);
        return numbers;
    }

    public static List<Integer> MakeFlattend(ArrayList<List<Integer>> mylotto) {
        List<Integer> flattenedList = new ArrayList<>();
        for (List<Integer> sublist : mylotto) {
            flattenedList.addAll(sublist);
        }
        return flattenedList;
    }

    public static void ResultLottoPaper(int cnt, ArrayList<List<Integer>> mylotto) {
        System.out.println();
        System.out.println(cnt + "개를 구매했습니다.");
        for (List<Integer> row : mylotto) {
            System.out.println(row);
        }
    }
}

class WinnigNum {
    public static String InputLottoNum() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningnum = Console.readLine();
        return winningnum;
    }

    public static List<Integer> LottoNum(String winningnum) {
        String[] num = winningnum.split(",");
        List<Integer> num_lst = new ArrayList<>();
        for (String str : num) {
            num_lst.add(Integer.parseInt(str.trim()));
        }
        return num_lst;
    }

    public static String InputBonus() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusnum = Console.readLine();
        return bonusnum;
    }

    public static int BonusNum(String bonusnum) {
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

    public static List<Integer> MatchCount(List<Integer> nums, List<Integer> num_lst, int mat_num, List<Integer> match_cnt, int bonus) {
        List<Integer> matchcnt = new ArrayList<>(match_cnt);
        for (int i = 0; i < nums.size(); i++) {
            if (i % 6 == 0 || i == nums.size() - 1) {
                int n = SpecialCount(mat_num, bonus, nums);
                matchcnt.set(n, matchcnt.get(n) + 1);
                mat_num = 0;
            }
            if (num_lst.contains(nums.get(i))) {
                mat_num += 1;
            }
        }
        return matchcnt;
    }

    public static int SpecialCount(int mat_num, int bonus, List<Integer> nums) {
        if (mat_num == 5 && nums.contains(bonus)) {
            return 6;
        }
        return mat_num;
    }

    public static int Rank(List<Integer> match_cnt) {
        Collections.reverse(match_cnt);
        int[] rank_cnt = {0, 0, 0, 0, 0};
        int prize = 0;
        PrizeRank[] ran = PrizeRank.values();
        for (int i = 0; i <= 4; i++) {
            if (match_cnt.get(i) != 0) {
                rank_cnt[i] += match_cnt.get(i);
                prize += ran[i].getPrizeAmount() * match_cnt.get(i);
            }
        }
        WinningResult.RankResult(rank_cnt);
        return prize;
    }

    public static double EarningRate(int prize, int money) {
        return (1.0 / ((double) money / (double) prize)) * 100;
    }
}

class WinningResult {
    public static void RankResult(int[] rank_cnt) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + rank_cnt[4] + "개");
        System.out.println("4개 일치 (50,000원) - " + rank_cnt[3] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + rank_cnt[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rank_cnt[1] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + rank_cnt[0] + "개");
    }

    public static void EarningResult(double earningrate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", earningrate);
    }
}