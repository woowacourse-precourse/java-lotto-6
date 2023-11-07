package lotto;

import java.util.ArrayList;

public class ExceptionHandler {

    public static void checkWinningNumbersValidity(ArrayList<String> winningNumbers) {

        ArrayList<Integer> duplication = new ArrayList<>();

        for (int i = 0; i < winningNumbers.size(); i++) {
            String some = winningNumbers.get(i);
            int winningNumber = -1;

            try {
                winningNumber = Integer.parseInt(String.valueOf(some));
            }catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
            }

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

}
