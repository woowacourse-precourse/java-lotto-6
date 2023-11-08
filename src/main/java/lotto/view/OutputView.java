package lotto.view;

import lotto.constant.message.LottoMessage;

public class OutputView {

    public void printMessage(LottoMessage inputMoney) {

    }

    public void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
