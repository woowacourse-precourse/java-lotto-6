package lotto.view;

import java.text.DecimalFormat;
import lotto.constant.Message;

public class OutputView {
    public void printErrorMessage(String errorMessage) {
        System.out.printf(Message.ERROR_TEMPLATE, errorMessage);
    }

    public void printPurchasedLotto(String allLotto){
        System.out.println(allLotto);
    }

    public void printTotalResult(String message, double interestRate){
        DecimalFormat decimalFormat = new DecimalFormat("#,###.0%");
        System.out.println(message);
        if(interestRate == 0) {
            System.out.println("0%");
            return;
        }
        System.out.println(decimalFormat.format(interestRate));
    }
}
