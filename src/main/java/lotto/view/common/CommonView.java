package lotto.view.common;

import lotto.view.constant.LottoMessage;

public class CommonView {
    public static void printConstantMessage(LottoMessage lottoMessage){
        System.out.println(lottoMessage.getMessage());
    }

    public static void printVariableMessage(String message){
        System.out.println(message);
    }

    public static void printWhiteSpace() {
        System.out.println();
    }
}
