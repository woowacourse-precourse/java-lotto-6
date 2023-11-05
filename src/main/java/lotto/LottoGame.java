package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lottos;

public class LottoGame {

    public static Lottos getRightCost(Lottos lottos) {
        try {
            lottos = new Lottos(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            return lottos;
        }
    }
}
