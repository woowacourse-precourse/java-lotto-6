package controller;

import camp.nextstep.edu.missionutils.Console;
import validate.Validator;
import view.InputView;

public class LottoController {
    InputView inputView = new InputView();
    Validator validator = new Validator();

    public void startLotto(){
        AskPrice();
        
    }
    public int AskPrice(){
        inputView.printAskPrice();
        return inputPrice();
    }
    public int inputPrice(){
        int my_price;
        try{
            my_price = validator.validatePrice(Console.readLine());
        }catch (NullPointerException e){
            return AskPrice();
        }catch (IllegalArgumentException e){
            return AskPrice();
        }
        return my_price;
    }
}
