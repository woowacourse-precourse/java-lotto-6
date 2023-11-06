package controller;

import service.Service;
import view.InputView;

public class Controller {
    Service service = new Service();

    public void run(){
        inputPriceControl();
    }
    public int inputPriceControl(){
        InputView.priceInputView();
        return service.inputPrice();
    }
}
