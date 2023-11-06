package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class BonusLotto {
    public int inputBonus(ArrayList<Integer> win_lottos) {
        // 5. 보너스 번호 입력
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus_lotto = Integer.parseInt(Console.readLine());
        if (bonus_lotto < 1 || bonus_lotto > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (win_lottos.contains(bonus_lotto)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        System.out.println();

        return bonus_lotto;
    }
}
