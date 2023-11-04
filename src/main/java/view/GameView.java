package view;

import config.CountMessage;
import config.OutputMessage;

public class GameView {

    public void printGameCount(int count) {
        System.out.printf(OutputMessage.PAYMENT.getMessage(),count);
    }

    public void printLottoList(String lottoList) {
        System.out.print(lottoList);
    }
}
