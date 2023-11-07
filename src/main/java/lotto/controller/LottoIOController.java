package lotto.controller;

import lotto.view.IOVIew;
import lotto.view.OutputMessage;

public class LottoIOController {
    private IOVIew iovIew;


    public LottoIOController() {
        this.iovIew = new IOVIew();
    }

    public void introOutput(){
        iovIew.showSingleMessage(OutputMessage.PURCHASE_INTRODUCE_MESSAGE.getMessage());
    }
}
