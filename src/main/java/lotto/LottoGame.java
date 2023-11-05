package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoGame {
    public static boolean getRightCost() {
        try {
            Lottos lottos = new Lottos(Console.readLine());
            return true;
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessage.WRONG_NUMBER_FORMAT.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.WRONG_COST.getMessage());
        }
        return false;
    }
}
