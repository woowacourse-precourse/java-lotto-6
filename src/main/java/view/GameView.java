package view;

import static config.OutputMessage.*;

import config.CountMessage;

public class GameView {

    public void printGameCount(int count) {
        System.out.printf(PAYMENT.getMessage(), count);
    }

    public void printLottoList(String lottoList) {
        System.out.print(lottoList);
    }

    public void printResult(int[] winCountArr) {
        System.out.println(RESULT.getMessage());
        for (CountMessage value : CountMessage.values()) {
            System.out.printf(value.getMessage(), winCountArr[value.getCount()]);
        }
    }

    public void printRate(Double rate) {
        System.out.printf(RATE.getMessage(), rate);
    }

}
