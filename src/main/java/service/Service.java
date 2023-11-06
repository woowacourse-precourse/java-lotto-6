package service;

import view.InputView;
import camp.nextstep.edu.missionutils.Console;
public class Service {
    public int inputPrice(){
        String price;
        InputView.priceInputView();
        price = Console.readLine();

        return Integer.parseInt(price);
    }
}
