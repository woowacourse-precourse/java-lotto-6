package lotto.exception;
import camp.nextstep.edu.missionutils.Console;
public class Exceptions {
    public static IllegalArgumentException exceptionInputPurchaseAmount() {
        return new IllegalArgumentException("[ERROR] 구매 금액은 1,000원 단위로 입력하세요.");
    }

    public static IllegalArgumentException exceptionLottoSize() {
        return new IllegalArgumentException("[ERROR] 로또의 번호가 6개가 아닙니다.");
    }


}
