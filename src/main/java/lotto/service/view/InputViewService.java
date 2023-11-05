package lotto.service.view;


import camp.nextstep.edu.missionutils.Console;
import lotto.common.Validator;
import lotto.model.Lotto;

import static lotto.common.ErrorMessageType.*;

/**
 * @Class : 로또 관리 UI 서비스 클래스
 */
public class InputViewService {

    public static int inputAmount(int lottoPrice) {
        int amount = ConvertStringToInt(getInputData());
        if (!Validator.isMultipleOfNumber(amount, lottoPrice)) {
            throw new IllegalArgumentException(ERROR_MIN_LOTTO_AMOUNT_UNIT.getLottoMessage());
        }
        return amount;
    }

    public static Lotto inputWinnigNumbers() {
        return null;
    }

    public static int inputBonusNumber() {
        return 0;
    }

    private static String getInputData() {
        String input = Console.readLine();
        System.out.println();
        return input;
    }

    private static int ConvertStringToInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NON_NUMERIC_INPUT.getLottoMessage());
        }
    }
}
