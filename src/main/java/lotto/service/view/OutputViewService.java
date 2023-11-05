package lotto.service.view;

import lotto.model.Lotto;

import java.util.List;

import static lotto.common.MessageType.*;

/**
 * @Class : 로또 관리 UI 서비스 클래스
 */
public class OutputViewService {

    public static void outputAmount() {
        System.out.println(ASK_PURCHASE_AMOUNT.getMessage());
    }

    public static void outputEa(int ea) {
        System.out.println(PURCHASED_LOTTO_FORMAT.getEaMessage(ea));
    }

    public static void outputLottoList(List<Lotto> lottoList) {
        lottoList.forEach(l -> System.out.println(l.toString()));
        System.out.println();
    }

    public static void outputWinnigNumbers() {
        System.out.println(ASK_WINNING_NUMBERS.getMessage());
    }

    public static void outputStatistics() {
    }

    public static void outputRateOfReturn() {
    }

    public static void outPutErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

}
