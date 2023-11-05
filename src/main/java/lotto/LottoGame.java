package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lottos;

public class LottoGame {
    public static boolean getRightCost() {
        try {
            Lottos lottos = new Lottos(Console.readLine());
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
