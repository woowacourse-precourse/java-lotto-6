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

    public static void outputAmount() {
        System.out.println(ASK_PURCHASE_AMOUNT.getMessage());
    }

    public static int inputAmount(int lottoPrice) {
        int amount = ConvertStringToInt(getInputData());
        if (!Validator.isMultipleOfNumber(amount, lottoPrice)) {
            throw new IllegalArgumentException(ERROR_MIN_LOTTO_AMOUNT_UNIT.getLottoMessage());
        }
        return amount;
    }

    public static void outputEa(int ea) {
        System.out.println(PURCHASED_LOTTO_FORMAT.getEaMessage(ea));
    }

    public static void outputLottoList(List<Lotto> lottoList) {
        lottoList.forEach(l -> System.out.println(l.toString()));
        System.out.println();
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
