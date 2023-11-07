package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String getPurchaseMoney() {
        return Console.readLine();
    }

    public static String getWinningNumber() {
        String winningNumber = Console.readLine();
        checkIsNumber(winningNumber);
        return winningNumber;
    }

    public static int getBonusNumber() {
        String bonusNumber = Console.readLine();
        checkIsNumber(bonusNumber);

        return Integer.parseInt(bonusNumber);
    }

    private static void checkIsNumber(String winningNumber) {
        if (winningNumber.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*") || winningNumber.matches("^[a-zA-Z]*$")) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요");
        }
    }

}
