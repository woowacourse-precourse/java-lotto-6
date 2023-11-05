package lotto.view;

import lotto.message.Message;

public class OutputView {

    public void printMessage(Message message) {
        System.out.println(message.getMessage());
    }

    public void printLottoCount(Message message, int purchaseCost) {
        System.out.printf(message.getMessage(), purchaseCost);
    }

}
