package lotto;

import java.util.ArrayList;
import java.util.List;

import lotto.Lotto;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    // 랜덤 번호 6개 뽑기
    private static List<Integer> setRandomNumbers() {
        List<Integer> box = new ArrayList<>();
        while (box.size() != 6) {
            int rd = Randoms.pickNumberInRange(1, 45);
            if (box.contains(rd))
                continue;
            box.add(rd);
        }
        return box;
    }

    private static List<Integer> getUserNumbers() {
        List<Integer> box = new ArrayList<>();
        for (String s : Console.readLine().split(",")) {
            box.add(Integer.parseInt(s));
        }
        return box;
    }

    private static int getUserBonus(Lotto userNumbers) {
        int bonus = Integer.parseInt(Console.readLine());
        if (userNumbers.lottoContains(bonus))
            throw new IllegalArgumentException();
        return bonus;
    }

    private static int judge(Lotto winNum, Lotto user, int bonus){
        int ct = winNum.countMatch(user.getNumbers());
        if(ct > 5){
            return 1;
        }
        if(ct > 4) {
            if (winNum.lottoContains(bonus)) return 2;
            return 3;
        }
        if(ct > 3) {
            return 4;
        }
        if(ct > 2) {
            return 5;
        }
        return 0;
    }

    private static int numOfLotto() {
        int money = Integer.parseInt(Console.readLine());
        if (money%1000 != 0) throw new IllegalArgumentException();
        System.out.println(String.format("%d개를 구매했습니다.",money/1000));
        return money/1000;
    }

    private static List<Lotto> setUser(){
        List<Lotto> user = new ArrayList<>();
        for (int i = 0; i < numOfLotto(); i++) {
            new Lotto(setRandomNumbers());     
        }          
        return user;
    }

    public static void main(String[] args) {
        List<Lotto> user = setUser();
        Lotto winNumber = new Lotto(getUserNumbers());
        int bonus = getUserBonus(winNumber); 
        

        List<Integer> res = new ArrayList<>(List.of(0,0,0,0,0,0));
        for (int i = 0; i < user.size(); i++) {
            int idx = judge(winNumber, user.get(i), bonus);
            res.add(idx, res.get(idx)+1);
        }
        System.out.println(res);
    }
}
