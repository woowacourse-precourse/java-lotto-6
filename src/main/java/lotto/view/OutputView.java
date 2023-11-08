package lotto.view;

import lotto.constant.OutputMessage;

public class OutputView {

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    public static void printPurChaseCount(int lottoCount) {
        System.out.println(lottoCount + OutputMessage.AFTER_INPUTTING_PURCHASE_AMOUNT.getMessage());
    }

    public static void printLottoNumbers(StringBuilder lottoNumbers) {
        System.out.println(lottoNumbers);
    }
}
