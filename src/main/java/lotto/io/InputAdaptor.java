package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.StringConverter;
import lotto.util.Validator;

import java.util.List;

/**
 * 사용자 입력을 읽고, 검증하고, 파싱된 데이터를 반환하는 어댑터 역할을 담당한다.
 */
public class InputAdaptor {

    /**
     * 구입 금액을 입력받는다. 구입 금액은 1,000원 단위로 입력받으며 1,000원으로 나누어 떨어지지 않을 경우
     * IllegalArgumentException가 발생한다.
     * @return 사용자가 입력한 구입 금액.
     * @throws IllegalArgumentException 사용자 입력이 정수가 아니거나 1,000원 단위가 아닐 경우 발생한다.
     */
    public static int readPurchasePrice() throws IllegalArgumentException {
        String rawStr = Console.readLine();
        Validator.validateStringToBeInteger(rawStr);
        return StringConverter.toInt(rawStr);
    }

    /**
     * 당첨 번호를 입력받는다. 번호 구분은 InputConfiguration 클래스에 정의된 DELIMITER_TO_PARSE_INPUT_OF_WINNING_NUMBER이다.
     * @return 입력된 당첨 번호가 담긴 리스트.
     * @throws IllegalArgumentException 다음 경우에 해당할 경우 발생한다.
     *                                  1. 당첨 번호가 6개가 아닐 경우, 즉 당첨 번호가 6개보다 적거나 많을 경우
     *                                  2. DELIMITER_TO_PARSE_INPUT_OF_WINNING_NUMBER로 구분된 각 번호 중 정수가 아닌
     *                                  문자가 존재할 경우
     *                                  3. 각 번호의 범위가 1~45에 포함되지 않을 경우
     */
    public static List<Integer> readWinningNumbers() throws IllegalArgumentException {
        String rawStr = Console.readLine();
        Validator.validateStringToBeMultipleIntegers(rawStr);
        return StringConverter.convertWinningNumbers(rawStr);
    }

    public static int readBonusNumber() {
        String rawStr = Console.readLine();
        Validator.validateStringToBeInteger(rawStr);
        return StringConverter.toInt(rawStr);
    }
}
