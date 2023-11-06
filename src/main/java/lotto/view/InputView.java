package lotto.view;

import static lotto.utils.InputValidator.blankCheck;
import static lotto.utils.InputValidator.lottoFormatCheck;
import static lotto.utils.InputValidator.lottoNumberRangeCheck;
import static lotto.utils.InputValidator.nullCheck;
import static lotto.utils.InputValidator.numberTypeCheck;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {
    }

    private static String input() {
        return Console.readLine();
    }

    /**
     * 구매 금액 입력
     *
     * @return String
     */
    public static String amountInput() {
        String amount = input();

        validateNullAndBlankCheck(amount);
        numberTypeCheck(amount);

        return amount;
    }

    /**
     * 로또 당첨 번호 입력
     *
     * @return String
     */
    public static String winLottoNumberInput() {
        String winLottoNumber = input();

        validateNullAndBlankCheck(winLottoNumber);
        lottoFormatCheck(winLottoNumber);

        return winLottoNumber;
    }

    /**
     * 보너스 당첨 번호 입력
     *
     * @return String
     */
    public static String bonusNumberInput() {
        String bonus = input();

        validateNullAndBlankCheck(bonus);
        numberTypeCheck(bonus);
        lottoNumberRangeCheck(bonus);

        return bonus;
    }

    /**
     * NULL, 빈값, 공백 검증
     *
     * @param inputValue
     */
    private static void validateNullAndBlankCheck(String inputValue) {
        nullCheck(inputValue);
        blankCheck(inputValue);
    }

}
