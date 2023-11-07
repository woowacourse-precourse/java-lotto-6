package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.Exception;

public class Buy {
    int totalAmount = 0;
    NumberGenerator generator = null;

    public void getGames() {

        Exception exception = new Exception();
        System.out.println("구입금액을 입력해주세요.");
        while(totalAmount < 1) {
            totalAmount = exception.checkInt(Console.readLine());
        }
    }
}
