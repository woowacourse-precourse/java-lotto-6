package lotto.view;

/* *
    입력
    - 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
    - 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.
    - 보너스 번호를 입력 받는다.
 */

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String lottoPurchaseAmountInput() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static String winningLottoNumbersInput() {
        System.out.printf("%n당첨 번호를 입력해 주세요.%n");
        return Console.readLine();
    }

    public static String winningLottoBonusNumberInput() {
        System.out.printf("%n보너스 번호를 입력해 주세요.%n");
        return Console.readLine();
    }
}
