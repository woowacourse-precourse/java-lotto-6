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

    public void printTotalResult(String totalResult){
        System.out.println(totalResult);
    }
}
