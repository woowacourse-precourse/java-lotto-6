package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


import lotto.Lotto;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    final static int[] prices = {2_000_000_000, 30_000_000, 1_500_000, 50_000, 5_000, 0};

    // 랜덤 번호 6개 뽑기
    private static List<Integer> setRandomNumbers() {
        List<Integer> box = new ArrayList<>();
        while (box.size() != 6) {
            int rd = Randoms.pickNumberInRange(1, 45);
            if (box.contains(rd))
                continue;
            box.add(rd);
        }
        Collections.sort(box);
        System.out.println(box);
        return box;
    }

    private static List<Integer> getUserNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> box = new ArrayList<>();
        for (String s : Console.readLine().split(",")) {
            box.add(Integer.parseInt(s));
        }
        System.out.println();
        return box;
    }

    private static int getUserBonus(Lotto userNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = Integer.parseInt(Console.readLine());
        if (userNumbers.lottoContains(bonus))
            throw new IllegalArgumentException();
        System.out.println();
        return bonus;
    }

    private static int judge(Lotto winNum, Lotto user, int bonus){
        int ct = winNum.countMatch(user.getNumbers());
        if(ct > 5){
            return 0;
        }
        if(ct > 4) {
            if (user.lottoContains(bonus)) return 1;
            return 2;
        }
        if(ct > 3) {
            return 3;
        }
        if(ct > 2) {
            return 4;
        }
        return 5;
    }

    private static int numOfLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        if (money%1000 != 0) throw new IllegalArgumentException();
        System.out.println();
        return money/1000;
    }

    private static List<Lotto> setUser(int n){
        System.out.println(String.format("%d개를 구매했습니다.", n));
        List<Lotto> user = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            user.add(new Lotto(setRandomNumbers()));
        }
        System.out.println();
        return user;
    }

    public static int[] resList(List<Lotto> user, Lotto winNumber, int bonus){
        int[] res = {0, 0, 0, 0, 0, 0};
        for (int i = 0; i < user.size(); i++) {
            int idx = judge(winNumber, user.get(i), bonus);
            res[idx]++;
        }
        return res;
    }

    public static int sumPrice(int[] res){
        int userPrice = 0;
        for (int i = 0; i < res.length; i++) {
            userPrice += prices[i]*res[i];
        }
        return userPrice;
    }

    public static void main(String[] args) {        
        int n = numOfLotto();
        List<Lotto> user = setUser(n);
        Lotto winNumber = new Lotto(getUserNumbers());
        int bonus = getUserBonus(winNumber); 

        int returnRate = sumPrice(resList(user, winNumber, bonus));
        
    }
}
