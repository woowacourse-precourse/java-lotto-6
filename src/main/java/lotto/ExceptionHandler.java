package lotto;

import java.util.ArrayList;
import java.util.List;

public class ExceptionHandler {

    public static void checkWinningNumbersValidity(List<Integer> winningNumbers) {

        ArrayList<Integer> duplication = new ArrayList<>();

        for (int i = 0; i < winningNumbers.size(); i++) {
            int some = winningNumbers.get(i);
            int winningNumber = -1;

            winningNumber = Integer.parseInt(String.valueOf(some));

            if (winningNumber > 45 || winningNumber < 1) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }

            if (duplication.contains(winningNumber)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복 숫자가 아니여야 합니다.");
            }

            duplication.add(winningNumber);
        }

        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6가지 입니다.");
        }
    }


    public static void checkMoneyUnitValidity(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0 || purchaseAmount <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkBonusNumber(Integer bonus, List<Integer> winningNumbers) {

        if (bonus > 45 || bonus <= 0) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        if (winningNumbers.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복 숫자가 아니여야 합니다.");
        }

    }

}
