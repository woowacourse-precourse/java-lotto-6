package controller;

import camp.nextstep.edu.missionutils.Console;
import view.InputView;

public class LottoController {
    InputView inputView = new InputView();

    public void startLotto(){
        inputView.printAskPrice();
        inputPrice();

    }
    public int inputPrice(){
        int price;
        price = Integer.parseInt(Console.readLine());
    }
}
