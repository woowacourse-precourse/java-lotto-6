package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import lotto.User;

public class Application {
    private static List<Integer> getUserNumbers() {
        List<Integer> box = new ArrayList<>();
        for (String s : Console.readLine().split(",")) {
            box.add(Integer.parseInt(s));
        }
        return box;
    }

    private static void judge(Lotto winNum, User user){
        int ct = winNum.countMatch(user.lotto.getNumbers());
        if(ct > 5){
            System.out.println("1등");
            return;
        }
        if(ct > 4) {
            if (winNum.lottoContains(user.bonus)) System.out.println("2등");
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
        User user = new User();

        judge(winNumber, user);
    }
}
