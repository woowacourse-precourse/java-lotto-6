package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

public class User {
    Lotto lotto;
    int bonus;

    public User(){
        this.lotto = new Lotto(setRandomNumbers());
        this.bonus = getUserBonus(lotto);
    }

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

    private static int getUserBonus(Lotto userNumbers) {
        int bonus = Integer.parseInt(Console.readLine());
        if (userNumbers.lottoContains(bonus))
            throw new IllegalArgumentException();
        return bonus;
    }
}
