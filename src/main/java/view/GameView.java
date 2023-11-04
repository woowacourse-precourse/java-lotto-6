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

    public void printResult(int[] winCountArr) {
        System.out.println(OutputMessage.RESULT.getMessage());
        for(CountMessage value : CountMessage.values()) {
            System.out.printf(value.getMessage(),winCountArr[value.getCount()]);
        }
    }

    public void printRate(Double rate) {
        System.out.printf(OutputMessage.RATE.getMessage(),rate);
    }

}
