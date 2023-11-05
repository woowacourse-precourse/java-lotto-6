package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoManager;

public class LottoGame {

    public static void getRightCost(LottoManager lottoManager) {
        try {
            lottoManager.setNumberOfLottos(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
