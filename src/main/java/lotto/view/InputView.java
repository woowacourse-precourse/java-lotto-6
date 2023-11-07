package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.exception.LottoError;
import lotto.exception.LottoValidationException;

public class InputView {

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return parseToInteger(Console.readLine());
    }

    private static int parseToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new LottoValidationException(LottoError.INVALID_PURCHASE_AMOUNT.toString());
        }
    }


    /**
     * 당첨 번호를 입력받는 메소드입니다.
     *
     * @return 입력받은 당첨 번호 목록
     */
    public static List<Integer> inputWinningNumbers() {
        return null;
    }

    /**
     * 보너스 번호를 입력받는 메소드입니다.
     *
     * @return 입력받은 보너스 번호
     */
    public static int inputBonusNumber() {
        return 0;
    }

}
