package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class BonusLotto {
    public int inputBonus(ArrayList<Integer> win_lottos) {
        // 5. 보너스 번호 입력
        int bonus_lotto = 0;
        boolean isValidInput = false;

        while(!isValidInput) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                bonus_lotto = Integer.parseInt(Console.readLine());

                Validation validation = new Validation();
                validation.isBetweenRangeNumber(bonus_lotto);
                validation.isNotDuplicated(bonus_lotto, win_lottos);

                isValidInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println();

        return bonus_lotto;
    }
}
