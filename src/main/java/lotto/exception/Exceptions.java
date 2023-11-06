package lotto.exception;
import camp.nextstep.edu.missionutils.Console;
public class Exceptions {
    public static void exceptionInputPurchaseAmount() {
        throw new IllegalArgumentException("[ERROR] 구매 금액은 1,000원 단위로 입력하세요.");
    }

}
