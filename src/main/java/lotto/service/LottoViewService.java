package lotto.service;


import camp.nextstep.edu.missionutils.Console;
import lotto.common.Validator;
import lotto.model.Lotto;

import java.util.List;

import static lotto.common.ErrorMessageType.*;
import static lotto.common.MessageType.*;

/**
 * @Class : 로또 관리 UI 서비스 클래스
 */
public class LottoViewService {

    private static final int MIN_LOTTO_AMOUNT_UNIT = 1000;

    public static void outputAmount() {
        System.out.println(ASK_PURCHASE_AMOUNT.getMessage());
    }

    public static int inputAmount() {
        int amount = ConvertStringToInt(Console.readLine());
        if (!Validator.isMultipleOfNumber(amount, MIN_LOTTO_AMOUNT_UNIT)) {
            throw new IllegalArgumentException(ERROR_MIN_LOTTO_AMOUNT_UNIT.getLottoMessage());
        }
        return amount;
    }

    public static void outputEa(int ea) {
    }

    public static void outputLottoList(List<Lotto> lottoList) {
    }

    public static Lotto inputWinnigNumbers() {
        return null;
    }

    public static int inputBonusNumber() {
        return 0;
    }

    public static void outputStatistics() {
    }

    public static void outputRateOfReturn() {
    }

    public static void outPutErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    private static int ConvertStringToInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NON_NUMERIC_INPUT.getLottoMessage());
        }
    }


}
