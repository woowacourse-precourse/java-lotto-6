package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoInputView {

    /**
     * 사용자로부터 구매 금액을 받는다.
     *
     * @return String 타입으로 반환한다.
     */
    public static String getPurchaseAmount() {
        return Console.readLine();
    }

    public static String getLottoWinningNumber() {
        return Console.readLine();
    }

    public static String getLottoBonusNumber() {
        return Console.readLine();
    }
}
