package lotto;

import java.util.ArrayList;
import java.util.List;

import lotto.Lotto;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    // 랜덤 번호 6개 뽑기
    public static List<Integer> setRandomNumbers() {
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

    private void judge(Lotto winNum, Lotto user, int bonus){
        int ct = winNum.countMatch(user.getNumbers());
        if(ct > 5){
            System.out.println("1등");
            return;
        }
        if(ct > 4) {
            if (winNum.lottoContains(bonus)) System.out.println("2등");
            else System.out.println("3등");
            return;
        }
        if(ct > 3) {
            System.out.println("4등");
            return;
        }
        if(ct > 2) {
            System.out.println("5등");
            return;
        }
        System.out.println("꽝");
    }

    public static void main(String[] args) {
        Lotto winNumber = new Lotto(getUserNumbers());
        Lotto user = new Lotto(setRandomNumbers());
        int bonus = getUserBonus(user);
    }
}
