package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.Exception;

public class Buy {
    NumberGenerator generator = null;
    public void getGames() {
        Exception exception = new Exception();
        System.out.println("구입금액을 입력해주세요.");
        int totalAmount = exception.checkInt(Console.readLine());
    }
}
