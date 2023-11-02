package lotto.controller;

import lotto.view.PrintMessage;

public class LottoController {
    public void startLotto(){
        setAmount();
    }

    public void setAmount(){
        PrintMessage.printStart();
    }
}
