package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.Constants;
import lotto.exception.Exception;

public class Buy {
    NumberGenerator generator = null;

    public int getGames() {
        int totalAmount = 0;
        boolean correctAmount = false;
        Exception exception = new Exception();
        System.out.println("구입금액을 입력해주세요.");
        while (!correctAmount || totalAmount < 1) {
            totalAmount = exception.checkInt(Console.readLine());
            correctAmount = exception.checkAmount(totalAmount, correctAmount);
        }
        return totalAmount/Constants.LOTTOPRICE;
    }
}
